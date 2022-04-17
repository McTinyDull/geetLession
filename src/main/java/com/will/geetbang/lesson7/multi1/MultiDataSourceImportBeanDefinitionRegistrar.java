package com.will.geetbang.lesson7.multi1;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;
import java.util.stream.Collectors;

import static com.will.geetbang.lesson7.multi1.MultiDataSourceProperties.PREFIX;

/**
 * @Description TODO
 * @Author Will
 * @Date 2022/4/17 11:37 PM
 */
public class MultiDataSourceImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar, EnvironmentAware {
    public static final String DATASOURCE_BEANNAME = "dynamicDataSourceRouter";
    private Environment environment;

    @Override
    public void registerBeanDefinitions( AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        MultiDataSourceProperties multiDataSourceProperties = Binder.get(environment)
                .bind(PREFIX, MultiDataSourceProperties.class)
                .orElseThrow(() -> new RuntimeException("no found dynamicds config"));
        final HikariDataSource[] defaultTargetDataSource = {null};
        Map<Type, HikariDataSource> targetDataSources = multiDataSourceProperties.getDataSources().entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> {
                            MultiDataSourceProperties.DataSourceProperties dataSourceProperties = entry.getValue();
                            HikariDataSource dataSource = DataSourceBuilder.create()
                                    .type(HikariDataSource.class)
                                    .driverClassName(dataSourceProperties.getDriverClassName())
                                    .url(dataSourceProperties.getUrl())
                                    .username(dataSourceProperties.getUsername())
                                    .password(dataSourceProperties.getPassword())
                                    .build();
                            dataSource.setPoolName("HikariPool-" + entry.getKey());
                            if (Type.MASTER == entry.getKey()) {
                                defaultTargetDataSource[0] = dataSource;
                            }
                            return dataSource;
                        }));
        targetDataSources.remove(Type.MASTER);
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(DynamicDataSourceRouter.class)
                .addConstructorArgValue(defaultTargetDataSource[0])
                .addConstructorArgValue(targetDataSources)
                .getBeanDefinition();
        registry.registerBeanDefinition(DATASOURCE_BEANNAME, beanDefinition);
    }

    @Override
    public void setEnvironment( Environment environment) {
        this.environment = environment;
    }
}

package com.will.geetbang.lesson7.multi1;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static com.will.geetbang.lesson7.multi1.MultiDataSourceProperties.PREFIX;


/**
 * @Description TODO
 * @Author Will
 * @Date 2022/4/17 11:28 PM
 */
@Data
@Configuration
@ConfigurationProperties(prefix = PREFIX)
public class MultiDataSourceProperties {
    public static final String PREFIX = "dynamic";
    private Map<Type, DataSourceProperties> dataSources;

    @Data
    public static class DataSourceProperties {
        private String driverClassName;
        private String url;
        private String username;
        private String password;
    }
}

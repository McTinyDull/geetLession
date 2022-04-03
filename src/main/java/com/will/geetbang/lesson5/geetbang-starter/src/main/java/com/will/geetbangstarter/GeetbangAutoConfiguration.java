package com.will.geetbangstarter;

import com.alibaba.fastjson.JSON;
import com.will.geetbangstarter.prop.SpringBootPropertiesConfiguration;
import com.will.geetbangstarter.prop.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description TODO
 * @Author Will
 * @Date 2022/4/3 11:43 PM
 */
@Configuration
@EnableConfigurationProperties(SpringBootPropertiesConfiguration.class)
@ConditionalOnProperty(prefix = "will",name = "enabled",havingValue = "true")
public class GeetbangAutoConfiguration {
    @Autowired
    private SpringBootPropertiesConfiguration props;

    @Bean
    public Student getStudent() {
        Student student = new Student();
        student.setName(props.getProps().getProperty("name"));
        student.setAge(Integer.parseInt(props.getProps().getProperty("age")));
        return student;
    }
}

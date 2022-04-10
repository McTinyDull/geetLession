package com.will.geetbang.lesson5;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description TODO
 * @Author Will
 * @Date 2022/4/3 10:05 PM
 */
@Configuration
public class MyConfig {
    @Bean
    public LocalStudent getLocalStudent(){
        LocalStudent student = new LocalStudent();
        student.setName("will");
        student.setAge(18);
        return student;
    }
}

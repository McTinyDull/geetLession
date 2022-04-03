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
    public Student getStudent(){
        Student student = new Student();
        student.setName("will");
        student.setAge(18);
        return student;
    }
}

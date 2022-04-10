package com.will.geetbang.lesson5;

import com.alibaba.fastjson.JSON;
import com.will.geetbangstarter.prop.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @Description TODO
 * @Author Will
 * @Date 2022/4/3 10:06 PM
 */
@Service
public class MyService {
    @Autowired
    private LocalStudent localStudent;
    @Autowired
    private Student student;
    @PostConstruct
    private void init(){
        System.out.println(JSON.toJSONString(localStudent));
        System.out.println(JSON.toJSONString(student));
    }
}

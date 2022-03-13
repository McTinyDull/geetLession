package com.will.geetbang.lession2;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author Will
 * @Date 2022/3/13 11:03 PM
 */
public class Mian {
    public static void main(String[] args) throws IOException {
        String url = "http://localhost:8081/hello";
        Map<String,Object> result = OkHttpClientUtil.getInstance().post(url,new HashMap<>());
        System.out.println(result);
    }
}

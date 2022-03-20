package com.will.geetbang.lession2;

import okhttp3.Response;

import java.io.IOException;
import java.util.HashMap;

/**
 * @Description TODO
 * @Author Will
 * @Date 2022/3/13 11:03 PM
 */
public class Mian {
    public static void main(String[] args) throws IOException {
        String url = "http://localhost:8888";
        Response result = OkHttpClientUtil.getInstance().post(url,new HashMap<>());
        System.out.println(result);
        System.out.println(result.headers());
    }
}

package com.will.geetbang.lession2;

import com.alibaba.fastjson.JSON;
import okhttp3.*;

import javax.net.ssl.*;
import java.io.IOException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author mark
 * @title: OkHttpClientUtil
 * @projectName dmpnew-bullet
 * @description: okhttp 的基本使用
 * @date 2019-10-18 14:00
 */
public class OkHttpClientUtil {

    public static final MediaType json = MediaType.parse("application/json; charset=utf-8");

    private volatile static OkHttpClientUtil instance;

    private final OkHttpClient okHttpClient;

    public static OkHttpClientUtil getInstance() {
        if (instance == null) {
            synchronized (OkHttpClientUtil.class) {
                if (instance == null) {
                    instance = new OkHttpClientUtil();
                }

            }
        }
        return instance;
    }

    public OkHttpClientUtil() {
        this.okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(20000L, TimeUnit.MILLISECONDS)
                .readTimeout(20000L, TimeUnit.MILLISECONDS)
                .sslSocketFactory(createSSLSocketFactory(),new TrustAllManager())
                .hostnameVerifier(new TrustAllHostnameVerifier())
                .addInterceptor(new RetryIntercepter(2))
                .build();
    }


    public Response post(String url, Map<String, Object> params) throws IOException {
        return post(url,params,null);
    }

    public Response post(String url, Map<String, Object> params,Map<String,String> headers) throws IOException {
        String tag = UUID.randomUUID().toString();
        String postData = JSON.toJSONString(params);
//        Log.message(String.format("httpclient send,url:%s,param:%s,headers:%s,uuid:%s",url,params==null?"":postData,headers==null?"":headers,tag));
        RequestBody body = RequestBody.create(OkHttpClientUtil.json, postData);
        Request.Builder builder = new Request.Builder();
        if(headers!=null && !headers.isEmpty()){
            headers.forEach(builder::addHeader);
        }
        return okHttpClient.newCall(builder.url(url).post(body).build()).execute();
    }


    public class RetryIntercepter implements Interceptor {

        public int maxRetry;
        private int retryNum = 0;

        public RetryIntercepter(int maxRetry) {
            this.maxRetry = maxRetry;
        }

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Response response = chain.proceed(request);
//            Log.message("request retry:" + request.url());
            while (!response.isSuccessful() && retryNum < maxRetry) {
                retryNum++;
                response.close();
                response = chain.proceed(request);
            }
            return response;
        }
    }

    /**
     * https 证书相关
     *
     * @return
     */
    private static SSLSocketFactory createSSLSocketFactory() {
        SSLSocketFactory sSLSocketFactory = null;
        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, new TrustManager[]{new TrustAllManager()},
                    new SecureRandom());
            sSLSocketFactory = sc.getSocketFactory();
        } catch (Exception e) {
        }
        return sSLSocketFactory;
    }

    private static class TrustAllManager implements X509TrustManager {
        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType)
                throws CertificateException {
        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType)
                throws CertificateException {
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    private static class TrustAllHostnameVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }
}

package com.will.geetbang.lession1;

import java.io.*;
import java.lang.reflect.Method;

/**
 * @Description 自定义一个 Classloader，加载一个 Hello.xlass 文件，执行 hello 方法，此文件内容是一个 Hello.class 文件所有字节
 * （x=255-x）处理后的文件。文件群里提供。
 * @Author Will
 * @Date 2022/3/5 4:35 PM
 */
public class MyClassLoader extends ClassLoader{

    public static void main(String[] args) throws Exception {
         Class<?> myClass = new MyClassLoader().loadClass("Hello");
         Object myObject = myClass.getDeclaredConstructor().newInstance();
        for (Method declaredMethod : myClass.getDeclaredMethods()) {
            System.out.println("method name:"+ declaredMethod.getName());
            declaredMethod.invoke(myObject);
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try(InputStream inputStream = new FileInputStream(String.format("file/%s.xlass",name))){
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = (byte) (255 - bytes[i]);
            }
            return defineClass(name,bytes,0,bytes.length);
        }catch (Exception e){
            throw new ClassNotFoundException();
        }
    }
}

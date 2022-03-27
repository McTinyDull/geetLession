package com.will.geetbang.lesson4;

import java.util.concurrent.*;

/**
 * @Description TODO
 * @Author Will
 * @Date 2022/3/27 9:30 PM
 */
public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //1、future
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        Future<String> future = executorService.submit(() -> "Hello Word!");
//        System.out.println(future.get());
//        executorService.shutdown();

        //2、futureTask
        FutureTask<String> task = new FutureTask<>(() -> "Hello Wold!");
        new Thread(task).start();
        System.out.println(task.get());
    }
}

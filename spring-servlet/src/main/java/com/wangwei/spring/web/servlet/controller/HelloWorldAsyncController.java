package com.wangwei.spring.web.servlet.controller;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Random;
import java.util.concurrent.*;

/**
 * 异步controller
 * @Auther wangwei
 * @Date 2018/11/25 5:12 AM
 */
@RestController
@EnableScheduling
public class HelloWorldAsyncController {

    BlockingQueue<DeferredResult<String>> queue = new ArrayBlockingQueue<>(5);

    //超时随机数
    private final Random random = new Random();

    /**
        1.cron是设置定时执行的表达式，如 0 0/5 * * * ?每隔五分钟执行一次
        2.zone表示执行时间的时区
        3.fixedDelay 和fixedDelayString 表示一个固定延迟时间执行，上个任务完成后，延迟多长时间执行
        4.fixedRate 和fixedRateString表示一个固定频率执行，上个任务开始后，多长时间后开始执行
        5.initialDelay 和initialDelayString表示一个初始延迟时间，第一次被调用前延迟的时间
     * @throws InterruptedException
     */
    @Scheduled(fixedRate = 5000)
    public void process() throws InterruptedException {//定时操作

        DeferredResult<String> result = null;

        do {
            result = queue.take();

            //随机超时时间
            long timeout = random.nextInt(100);

            //模拟等待时间
            Thread.sleep(timeout);

            result.setResult("hello, world");

            //计算结果
            println("执行计算结果, 消耗" + timeout + "ms." );

        }while (result != null);
    }

    @GetMapping("/callable-hello-world")
    public Callable<String> callableHelloWorld(){

        final long startTime = System.currentTimeMillis();

        println("hello, world");

        return () -> {
            long  costTime = System.currentTimeMillis() - startTime;
            println("执行计算结果, 消耗" + costTime + "ms." );
            return "hello, world";
        };

    }

    @GetMapping("/completionStage")
    public CompletionStage<String> completionStage(){
       final long startTime = System.currentTimeMillis();

        println("hello, world");

        return CompletableFuture.supplyAsync(() -> {
            long  costTime = System.currentTimeMillis() - startTime;
            println("执行计算结果, 消耗" + costTime + "ms." );
            return "hello, world";//异步执行结果
        });
    }

    @GetMapping("/hello-world")
    public DeferredResult<String> helloWorld(){
        DeferredResult<String> result = new DeferredResult<>(50L);

        //入队操作
        queue.offer(result);

        println("hello, world");

        result.onCompletion(() -> {
            println("执行结束");
        });

        result.onTimeout(() -> {
            println("执行超时");
        });
        return result;
    }


    private static void println(Object obj){
        String threadName = Thread.currentThread().getName();
        System.out.println("HelloWorldAsyncController[" + threadName +"]:" + obj);
    }

}

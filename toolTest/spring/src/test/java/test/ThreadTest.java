package test;


import com.google.common.collect.Lists;
import com.google.common.util.concurrent.RateLimiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.ArrayList;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class ThreadTest {

    ThreadPoolTaskExecutor executor;

    ExecutorService executorService = Executors.newFixedThreadPool(500);

    ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

    @BeforeEach
    void init() {
        System.out.println("init");

        executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(32);
        executor.setMaxPoolSize(32);
        executor.setQueueCapacity(64);
        executor.setThreadNamePrefix("myThread-");
        //executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
        //executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        executor.setAwaitTerminationSeconds(60);
        executor.setKeepAliveSeconds(120);
        executor.setWaitForTasksToCompleteOnShutdown(true);

        executor.initialize();


        System.out.println("init done");
    }


    @Test
    void test01() {
        System.out.println("test01");


        //CompletableFuture.runAsync(() -> {
        //    IntStream.rangeClosed(1, 100).forEach(i -> {
        //        Future<String> future = test02(i);
        //        futureList.add(future);
        //    });
        //});


        RateLimiter rateLimiter = RateLimiter.create(150);


        for (int a = 0; a < 10000; a++) {
            final int num = a;


            CompletableFuture.runAsync(() -> {
                runTask(num);
            }, executorService);

            if ( a % 150 == 0) {
                try {
                    TimeUnit.SECONDS.sleep(1L);
                } catch (InterruptedException e) {

                }
            }

            //System.out.println("a=" + a);
        }


        //Future<String> future = test02(2);

        //CompletableFuture.runAsync(() -> {
        //
        //});


        System.out.println("8899");
        try {
            TimeUnit.SECONDS.sleep(20L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    Future<String> test02(int num) {
        Future<String> future = executor.submit(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(500L);
            } catch (InterruptedException e) {
                System.out.println("interrupt");
            }
            //System.out.println("num=" + num);
            return "num=" + num;
        });
        return future;
    }

    void test03(Future<String> future) {
        try {
            System.out.println("getActiveCount = " + executor.getActiveCount());
            long start = System.currentTimeMillis();
            //String s = future.get(3, TimeUnit.SECONDS);
            String s = future.get();
            //String s = future.get(100, TimeUnit.MILLISECONDS);
            long cost = System.currentTimeMillis() - start;
            System.out.println("future.get cost = " + cost);
            //System.out.println(s);
        } catch (InterruptedException e) {
            System.out.println("interrupt");
        } catch (ExecutionException e) {
            System.out.println("error");
        } catch (Exception e) {
            System.out.println("Exception");
        }
    }


    void runTask(int num) {
        long start = System.currentTimeMillis();

        ArrayList<Future<String>> futureList = Lists.newArrayList();

        IntStream.rangeClosed(1, 10).forEach(i -> {
            Future<String> future = test02(i);
            futureList.add(future);
        });

        //try {
        //    TimeUnit.SECONDS.sleep(1L);
        //} catch (InterruptedException e) {
        //
        //}

        //for (int i = 0; i < 10; i++) {
        //    Future<String> future = test02(i);
        //    futureList.add(future);
        //}

        //IntStream.rangeClosed(1, 10).forEach(i -> {
        //
        //});

        for (Future<String> future : futureList) {
            test03(future);
        }



        System.out.println("num=" + num + ", cost=" + (System.currentTimeMillis() - start));
    }


}

package com.test.thread;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @date 2022/6/21
 */
public class ThreadTest {

    private static final LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(5);

    private static final ExecutorService executorService = new ThreadPoolExecutor(2, 4, 10, TimeUnit.SECONDS, queue);


    @Test
    void t1() throws ExecutionException, InterruptedException {


        Callable<String> callable = () -> {
            TimeUnit.SECONDS.sleep(5L);
            return "";
        };

        FutureTask<String> stringFutureTask = new FutureTask<>(callable);
        new Thread(stringFutureTask).start();

        String res = stringFutureTask.get();

        System.out.println(123);

    }

    @Test
    void t2() throws ExecutionException, InterruptedException {
        Callable<String> callable = () -> {
            TimeUnit.SECONDS.sleep(5L);
            return "";
        };


        Future<String> future = executorService.submit(callable);

        String res = future.get();

        System.out.println(123);
    }


    public void t() {


    }


    @Test
    void t3() throws ExecutionException, InterruptedException, TimeoutException {

        CompletableFuture<ArrayList<Integer>> future1 = CompletableFuture.supplyAsync(() -> {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(2);
            list.add(3);

            try {
                TimeUnit.SECONDS.sleep(3L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return list;
        });

        CompletableFuture<ArrayList<Integer>> future2 = CompletableFuture.supplyAsync(() -> {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(2);
            list.add(3);

            try {
                TimeUnit.SECONDS.sleep(1L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return list;
        });

        ArrayList<Integer> list1 = future1.get(5L, TimeUnit.SECONDS);
        ArrayList<Integer> list2 = future2.get(5L, TimeUnit.SECONDS);

        System.out.println(123);
        System.out.println(list1);
        System.out.println(list2);
    }


}

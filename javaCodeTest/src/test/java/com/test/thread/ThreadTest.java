package com.test.thread;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.concurrent.*;

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


    @Test
    void t04() throws InterruptedException {

        ExecutorService executorService = new ThreadPoolExecutor(
                2, 4,
                10, TimeUnit.SECONDS,
                queue,
                new MyThreadFactory((t, e) -> System.out.println("线程" + t.getName() + "异常" + e))
        );

        //try {
        //    executorService.execute(() -> {
        //        try {
        //            Integer.valueOf("a");
        //        } catch (Exception e) {
        //            System.out.println("异常" + e);
        //            throw e;
        //        }
        //    });
        //} catch (Exception e) {
        //    System.out.println("外层异常" + e);
        //}

        try {
            Future<?> future = executorService.submit(() -> {
                try {
                    Integer.valueOf("a");
                } catch (Exception e) {
                    System.out.println("异常" + e);
                    throw e;
                }
            });
            future.get(1L, TimeUnit.SECONDS);
        } catch (Exception e) {
            System.out.println("外层异常" + e);
        }

        TimeUnit.SECONDS.sleep(2L);
    }

    public static class MyThreadFactory implements ThreadFactory {


        private final Thread.UncaughtExceptionHandler exceptionHandler;

        public MyThreadFactory(Thread.UncaughtExceptionHandler exceptionHandler) {
            this.exceptionHandler = exceptionHandler;
        }

        /**
         * Constructs a new {@code Thread}.  Implementations may also initialize
         * priority, name, daemon status, {@code ThreadGroup}, etc.
         *
         * @param r a runnable to be executed by new thread instance
         * @return constructed thread, or {@code null} if the request to
         * create a thread is rejected
         */
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            System.out.println(123);
            // 设置异常处理器
            thread.setUncaughtExceptionHandler(exceptionHandler);
            return thread;
        }
    }

}

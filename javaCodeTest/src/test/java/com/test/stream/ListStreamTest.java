package com.test.stream;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @date 2022/5/13
 */
public class ListStreamTest {


    @Test
    void t1() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        List<Integer> res = list.stream().filter(item -> item > 2).collect(Collectors.toList());
        System.out.println(res);
    }

    @Test
    void t2() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        //Integer res = list.stream().filter(item -> item == 5).findFirst().get();

        Integer res = list.stream().filter(item -> item == 5).findFirst().orElse(null);

        System.out.println(res);
    }

    @Test
    void t3() {
        // 默认使用ForkJoinPool.commonPool()
        IntStream.range(1, 10).parallel().forEach(item -> {
            System.out.println(Thread.currentThread()); // Thread[ForkJoinPool.commonPool-worker-1,5,main]
        });
    }

    @Test
    void t4() {
        ForkJoinPool forkJoinPool = new ForkJoinPool(4);
        ForkJoinTask<String> task = forkJoinPool.submit(() -> {
            return "test";
        });

        try {
            String res = task.get();
            System.out.println(res);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    void t5() {
        StringJoiner joiner = new StringJoiner("-");

        Arrays.asList("1", "2", "3").stream().forEach(joiner::add);

        System.out.println(joiner.toString());
    }


}

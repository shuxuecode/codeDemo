package com.test.core.juc;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author shuxuecode
 * @date 2025/1/10
 */
public class CompletableFutureTest {


    @Test
    void t1() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {

            if (1==1) {
                throw new RuntimeException("123");
            }
            return "hello world";
        });

        String s = null;
        try {
            s = future.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        System.out.println(s);
    }

}

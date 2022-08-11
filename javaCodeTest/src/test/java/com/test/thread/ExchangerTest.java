package com.test.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @date 2022/8/11
 */
public class ExchangerTest {

    Exchanger<String> exchanger = new Exchanger<>();


    @Test
    void t1() {
        new Thread(() -> {
            String data = "-线程1";
            System.out.println(Thread.currentThread().getName() + data);
            try {
                // 开始交换数据
                data = exchanger.exchange(data);
                System.out.println(Thread.currentThread().getName() + data);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();


        new Thread(() -> {
            String data = "-线程2";
            System.out.println(Thread.currentThread().getName() + data);
            try {
                data = exchanger.exchange(data);
                System.out.println(Thread.currentThread().getName() + data);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }


    @Test void 超时(){
        new Thread(() -> {
            String data = "-线程2";
            System.out.println(Thread.currentThread().getName() + data);
            try {
                data = exchanger.exchange(data, 5L, TimeUnit.SECONDS);
                System.out.println(Thread.currentThread().getName() + data);
            } catch (InterruptedException | TimeoutException e) {
                throw new RuntimeException(e);
            }
        }).start();


        try {
            Thread.sleep(6000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    @Test void 中断() throws InterruptedException {
        Thread thread = new Thread(() -> {
            String data = "-线程2";
            System.out.println(Thread.currentThread().getName() + data);
            try {
                data = exchanger.exchange(data);
                System.out.println(Thread.currentThread().getName() + data);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        thread.start();

        Thread.sleep(3000L);
        thread.interrupt();
    }

}

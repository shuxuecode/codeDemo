package com.test.core.juc;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

    ReentrantLock lock = new ReentrantLock();


    @Test
    void test1() {


        new Thread() {
            @Override
            public void run() {
                t1();
            }
        }.start();

        new Thread(() -> t2()).start();
        new Thread(() -> t1()).start();

    }


    public void t1() {
        try {
            boolean bool = lock.tryLock(1L, TimeUnit.SECONDS);
            System.out.println(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            if (lock.isLocked()) {
                lock.unlock();
            }
        }
    }

    public void t2() {
        try {
            boolean bool = lock.tryLock(1L, TimeUnit.SECONDS);
            System.out.println(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            if (lock.isLocked()) {
                lock.unlock();
            }
        }
    }

}

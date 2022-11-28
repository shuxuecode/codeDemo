package com.test.core.juc;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @date 2022/11/28
 */
public class AtomicTest {

    @Test
    void t1() {
        AtomicLong atomicLong = new AtomicLong(0);
        run1("", atomicLong);

        System.out.println(atomicLong.get());
    }


    private void run1(String name, AtomicLong atomicLong) {
        System.out.println("run1");
        atomicLong.incrementAndGet();

        run2(name, atomicLong);
    }

    private void run2(String name, AtomicLong atomicLong) {
        System.out.println("run2");
        atomicLong.incrementAndGet();
    }

//


    @Test
    void t2() {
        //long l = 0; // 基本类型不行
        Long l = 0L; // 不行
        run11("", l);

        System.out.println(l);
    }


    private void run11(String name, Long atomicLong) {
        System.out.println("run1");
        atomicLong = atomicLong + 1;

        run22(name, atomicLong);
    }

    private void run22(String name, Long atomicLong) {
        System.out.println("run2");
        atomicLong = atomicLong + 1;
    }
}

package com.test;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @date 2022/4/6
 */
public class BigDecimalTest {

    @Test
    void 科学计数法导致耗时特别长() {
        long start = System.currentTimeMillis();

        String num = "12e-123456789";

        System.out.println(new BigDecimal(num).setScale(0, RoundingMode.DOWN));

        long end = System.currentTimeMillis();

        System.out.println("耗时 ： " + (end - start) + "ms");
        System.out.println("耗时 ： " + (end - start) / 1000 + "s");
        // 耗时基本在100秒以上

    }
}

package com.test;

import org.junit.jupiter.api.Test;

/**
 * @date 2022/3/29
 */
public class StringTest {


    @Test void t1(){
        String str = "a|b|c";
        String[] split = str.split("\\|");
        for (String s : split) {
            System.out.println(s);
        }
    }
}

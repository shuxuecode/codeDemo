package com.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

/**
 * @date 2022/4/1
 */
public class 正则表达式 {

    @Test
    void t1() {
        Pattern pattern = Pattern.compile("testName.*");
        boolean matches = pattern.matcher("testName$hidden").matches();
        Assertions.assertTrue(matches, "正则匹配失败");
    }


}

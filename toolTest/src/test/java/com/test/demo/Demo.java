package com.test.demo;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @date 2022/3/18
 */
public class Demo {

    @Test
    @DisplayName("单元测试")
    void t() {
        System.out.println(8899);
    }

    @Test
    @RepeatedTest(value = 5)
        // 标识方法可重复执行
    void t1() {
        System.out.println("t1");
    }

    @Test
    @DisplayName("断言")
    void t2() {
        Assertions.assertEquals(1, 2, "1 != 2");
    }

    @DisplayName("参数化测试")
    @ParameterizedTest
    @ValueSource(strings = {"a", "b", "c"})
    void t3(String str) {
        System.out.println(str);

        // @NullSource
        // @EnumSource
        //@CsvFileSource
        //@MethodSource
    }


    @DisplayName("方法参数类型测试")
    @ParameterizedTest
    @MethodSource("getStream")
    void t4(String str) {
        System.out.println(str);
    }

    static Stream<String> getStream() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        return list.stream();
    }


}

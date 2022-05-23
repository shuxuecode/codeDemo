package com.test.stream;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @date 2022/5/13
 */
public class ListStreamTest {


    @Test
    void t1(){
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
    void t2(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        //Integer res = list.stream().filter(item -> item == 5).findFirst().get();

        Integer res = list.stream().filter(item -> item == 5).findFirst().orElse(null);

        System.out.println(res);
    }

}

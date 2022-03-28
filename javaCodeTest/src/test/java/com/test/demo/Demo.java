package com.test.demo;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.NullString;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 */
public class Demo {

    @Test
    void t() {

        List<Integer> list = new ArrayList<>();
        list.add(Integer.valueOf(1000));
        list.add(Integer.valueOf(2000));

        int a = 1000;

        System.out.println(list.contains(a)); // true

        System.out.println(8899);
    }




}

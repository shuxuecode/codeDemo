package com.zsx.demo;

import lombok.Data;

import lombok.Builder;

import java.util.Date;

/**
 * @date 2022/8/26
 */
@Data
@Builder
public class Demo {
    private Integer id;

    private String name;

    private Date date;

    public static void test(){
        Demo build = Demo.builder()
                .id(1)
                .name("")
                .build();
    }
}

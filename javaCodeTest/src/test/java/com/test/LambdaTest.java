/*
Lambda表达式具有匿名、函数、传递、简洁这4大特性：
1、匿名：Lambda表达式不需要指定名称；
2、函数：Lambda表达式具有参数列表、函数主体和返回类型，还可能有可抛出的异常集合；
3、传递：Lambda表达式可以作为对象，作为参数对象传递给方法或存储于变量中；
4、简洁：Lambda表达式无需向匿名类那样写很多的样板代码。



 */

package com.test;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @date 2022/6/20
 */
public class LambdaTest {


    @Test
    void t2(){
// 分组统计
        ArrayList<Demo> list = new ArrayList<>();
        list.add(new Demo("a"));
        list.add(new Demo("a"));
        list.add(new Demo("a"));
        list.add(new Demo("a"));
        list.add(new Demo("b"));
        list.add(new Demo("b"));
        list.add(new Demo("c"));
        list.add(new Demo("c"));
        list.add(new Demo("c"));

        Map<String, Long> collect = list.stream().collect(Collectors.groupingBy(Demo::getName, Collectors.counting()));
        for (Map.Entry<String, Long> entry : collect.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }


    class Demo {
        String name;

        public Demo(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


    @Test
    void t1() {

        // 方法引用
        //Lambda1::getId;

        // 构造方法引用
        Optional.ofNullable(null).orElseGet(ArrayList::new);


        // 静态方法引用
        ArrayList<Integer> list = new ArrayList<>();
        list.forEach(System.out::println);

        Collections.sort(list, Integer::compare);


        //    实例方法引用
        LambdaTest lambdaTest = new LambdaTest();
        Integer integer = Optional.ofNullable(123).map(lambdaTest::getInt).orElse(0);
        Optional.ofNullable(123).map(this::getInt).orElse(0); // 如果方法在本身所在的类中，则可以直接用this

        // 参数类方法引用
        Optional.ofNullable(new Lambda1())
                //.map(Lambda1::getId)
                .map(Lambda1::getName)
                .orElse(null);
    }



    private int getInt(int num) {
        return num;
    }
}

class Lambda1 {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

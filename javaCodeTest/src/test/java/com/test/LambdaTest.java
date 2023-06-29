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
    void t3() {

        Lambda1 lambda1 = new Lambda1(1, "a");
        Lambda1 lambda2 = new Lambda1(2, "a");
        Lambda1 lambda3 = new Lambda1(3, "a");
        Lambda1 lambda4 = new Lambda1(4, "a");
        Lambda1 lambda5 = new Lambda1(5, "a");
        Lambda1 lambda6 = new Lambda1(6, "a");

        List<Lambda1> subList1 = new ArrayList<>();
        subList1.add(lambda1);
        subList1.add(lambda2);
        subList1.add(lambda3);
        subList1.add(lambda4);

        List<Lambda1> subList2 = new ArrayList<>();
        subList2.add(lambda5);
        subList2.add(lambda6);

        List<List<Lambda1>> list = new ArrayList<>();
        list.add(subList1);
        list.add(subList2);

        List<Lambda1> resultList = list.stream()
                .filter(item -> {
                    for (Lambda1 lambda11 : item) {
                        if (lambda11.getId() == 3) {
                            return true;
                        }
                    }
                    return false;
                })
                .findFirst().orElse(null);

        if (resultList != null) {
            resultList.stream().forEach(System.out::println);
        }

        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println();

        List<Lambda1> filteredList = filterList(list);
        if (filteredList != null) {
            filteredList.stream().forEach(System.out::println);
        }

    }


    public List<Lambda1> filterList(List<List<Lambda1>> list) {
        for (List<Lambda1> lambda1List : list) {
            for (Lambda1 lambda11 : lambda1List) {
                if (lambda11.getId() == 3) {

                    lambda1List = lambda1List.stream().filter(i -> {
                        return i.getId() <= 2;
                    }).collect(Collectors.toList());

                    return lambda1List;
                }
            }
        }
        return null;
    }



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


    public Lambda1() {
    }

    public Lambda1(int id, String name) {
        this.id = id;
        this.name = name;
    }

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

    @Override
    public String toString() {
        return "Lambda1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

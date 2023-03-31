package com.test.stream;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * @date 2023/3/31
 */
public class TreeMapTest {


    @Test
    void t1() {

        ArrayList<Demo> list = new ArrayList<>();
        list.add(new Demo("2", "2+b"));
        list.add(new Demo("1", "1-b"));
        list.add(new Demo("2", "2+c"));
        list.add(new Demo("2", "2+a"));
        list.add(new Demo("1", "1-a"));



        //TreeMap<String, List<Demo>> treeMap = list.stream()
        //        .collect(
        //                Collectors.groupingBy(
        //                        Demo::getId,
        //                        () -> new TreeMap<>(new DemoComparator()),
        //                        toList()
        //                )
        //        );

        TreeMap<String, List<Demo>> treeMap = list.stream()
                .collect(
                        Collectors.groupingBy(
                                Demo::getId,
                                () -> new TreeMap<>(String::compareTo),
                                toList()
                        )
                );

        for (Map.Entry<String, List<Demo>> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey());
            List<Demo> demoList = entry.getValue();
            demoList.stream().map(Demo::getName).forEach(System.out::println);

            System.out.println();
            System.out.println();
        }

    }


    class Demo {
        private String id;
        private String name;

        public Demo() {
        }

        public Demo(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


    class DemoComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    }

}
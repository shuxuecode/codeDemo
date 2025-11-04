package com.test.demo;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
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

        Set<Long> set = new HashSet<>();
        set.add(2000L);
        set.add(4000L);

        int b = 2000;
        long c = 2000L;

        System.out.println(set.contains(2000)); // false
        System.out.println(set.contains(b)); // false
        System.out.println(set.contains(c)); // true

    }


    @Test
    void t2() {
        // todo zsx

        // Comparison method violates its general contract

        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(2);

        AtomicInteger i = new AtomicInteger();

        list.sort((o1, o2) -> {

            i.getAndIncrement();

            System.out.println("== " + i);
            System.out.println(o2);
            System.out.println(o1);

            if (o1 == 1 && o2 == 3) {
                return -1;
            }

            if (o1 == 2 && o2 == 1) {
                if (i.get() == 4) {
                    return 0;
                }
                return 1;
            }

            if (o1 == 2 && o2 == 3) {
                return -1;
            }

            try {
                // Integer a = Integer.valueOf(map.get(o1));
                // Integer b = Integer.valueOf(map.get(o2));
                // if (a.equals(b)) {
                //     return 0;
                // } else if (a.compareTo(b) > 0) {
                //     return 1;
                // } else {
                //     return -1;
                // }
                return 0;
            } catch (Exception e) {
                return 1;
            }
        });

        System.out.println(list);

    }


}

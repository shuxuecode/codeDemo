package com.test.core.juc;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author shuxuecode
 * @date 2024/4/8
 */
public class CurrentHashMapTest {


    @Test
    void testDeadLock() {

        System.out.println("AaAa的hash值=" + "AaAa".hashCode());
        System.out.println("BBBB的hash值=" + "BBBB".hashCode());

        // 因为"AaAa"和“BBBB”的hash值相同，会定位到用一个bucket中，这样就形成了CAS嵌套，产生死循环问题

        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        map.computeIfAbsent("AaAa", k -> {
            return map.computeIfAbsent("BBBB", k2 -> 2);
        });

        /*
        原因是:

        map.computeIfAbsent(key1, mappingFunction)

        如果当前key1-hash对应的tab位(可以理解为槽)刚好是空的,在计算mappingFunction之前会
        step1: 先往对应位置放一个ReservationNode占位
        step2: 然后计算mappingFunction的值value,
        step3: 再将value组装成最终NODE, 把占位的ReservationNode换成最终NODE;

        这时如果:
         mappingFunction 中用到了 当前map的computeIfAbsent方法, 很不巧 key2-hash的槽为和key1的是同一个,
        因为key1已经在槽中放入了占位节点, 在处理key2时候for循环的所以处理条件都不符合 程序进入了死循环

        但是如果:

        key2-hash的槽位和key1的不一样, 是不会发生死循环
         */

        System.out.println(8899);


    }


}

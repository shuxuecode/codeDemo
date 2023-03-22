package com.zsx;

import cn.hutool.core.convert.NumberChineseFormatter;

import java.util.Random;

/**
 * @date 2023/3/22
 */
public class HutoolUtils {


    public static void main(String[] args) {

        Random random = new Random();


        for (int i = 0; i < 10; i++) {

            int num = random.nextInt(100_000_000);

            double number = num / 100d;

            String format = NumberChineseFormatter.format(number, true, true);
            System.out.println(String.valueOf(number) + " -> " + format);

        }

        System.out.println(NumberChineseFormatter.format(1_000_000, true, true));

    }

}

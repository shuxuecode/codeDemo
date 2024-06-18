package com.test;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * @author
 * @date 2022/6/6
 */
public class ProgressBarDemo {

    public static void main(String[] args) {
        char a = '_';
        char b = '=';

        int total = 100;

        StringBuilder builder = new StringBuilder();

        Stream.generate(() -> a).limit(total).forEach(builder::append);

        for (int i = 0; i < total; i++) {
            builder.replace(i, i + 1, String.valueOf(b));

            String progressBar = "\r" + builder;

            String percent = " " + (i + 1) + "%";
            System.out.println(progressBar + percent);

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

}

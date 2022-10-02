package com.test.datetime;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author
 * @date 2022/5/27
 */
public class DateTest {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Test
    void t1() throws ParseException {

        Date date1 = dateFormat.parse("2022-05-20 12:12:12");
        Date date2 = dateFormat.parse("2022-05-20 12:12:13");

        System.out.println(date1.after(date2));

    }

    @Test
    void t2() throws InterruptedException {
        Date date1 = new Date();
        System.out.println(date1.compareTo(date1));
        System.out.println(date1.compareTo(date1) == 0); // true

        TimeUnit.MILLISECONDS.sleep(5);

        Date date2 = new Date();
        System.out.println(date1.compareTo(date2)); // -1
        System.out.println(date1.compareTo(date2) < 0); // true


        System.out.println(date2.compareTo(date1)); // 1
        System.out.println(date2.compareTo(date1) > 0); // true

    }
}

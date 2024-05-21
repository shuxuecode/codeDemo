package com.test.datetime;

import org.junit.jupiter.api.Test;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * @date 2022/8/23
 */
public class CalendarTest {

    @Test void t1(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, -1);

        System.out.println(calendar.getTime());

    }



    @Test void t2(){
        Calendar calendar = Calendar.getInstance();

        System.out.println(calendar.getTime());
        System.out.println(calendar.toInstant().atZone(ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));
        System.out.println(calendar.get(Calendar.MILLISECOND));



        calendar.set(Calendar.HOUR_OF_DAY, 12);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        // calendar.set(Calendar.MILLISECOND, 0);

        System.out.println(calendar.getTime());
        System.out.println(calendar.toInstant().atZone(ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));

    }

}

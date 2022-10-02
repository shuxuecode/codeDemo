package com.test.datetime;

import org.junit.jupiter.api.Test;

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

}

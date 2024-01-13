package com.test.datetime;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.*;
import java.util.Date;

/**
 * @author
 * @date 2022/5/27
 */
public class DateTimeTest {

    public static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static final ZoneId zoneId = ZoneId.systemDefault();

    @Test
    void test() {

        
    }


    @Test
    void t2() {

        LocalDate groupCreateTime = new Date(1704856229000L).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        System.out.println(groupCreateTime);
        long days = ChronoUnit.DAYS.between(groupCreateTime, LocalDate.now());
        System.out.println(days);

    }

    @Test
    void t1() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        LocalDateTime localDateTime = now.minusDays(1);
        System.out.println(localDateTime);
        LocalDateTime localDateTime1 = localDateTime.withHour(0).withMinute(0).withSecond(0);
        System.out.println(localDateTime1);

        LocalDateTime dateTime = LocalDateTime.of(
                localDateTime1.getYear(),
                localDateTime1.getMonth(),
                localDateTime1.getDayOfMonth(), 0, 0);
        System.out.println(dateTime);

        Date from = Date.from(dateTime.atZone(zoneId).toInstant());
        System.out.println(from);

        LocalDateTime localDateTime2 = from.toInstant().atZone(zoneId).toLocalDateTime();
        System.out.println(localDateTime2);


    }


}

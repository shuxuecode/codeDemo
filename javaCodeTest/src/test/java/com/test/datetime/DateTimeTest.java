package com.test.datetime;

import org.junit.jupiter.api.Test;

import java.time.*;
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

        LocalDateTime now = LocalDateTime.now(ZoneId.systemDefault());

        LocalDateTime localDateTime = now.plusDays(1).toLocalDate().atStartOfDay();

        System.out.println(localDateTime.format(dateTimeFormatter));

        LocalDateTime localDateTime1 = now.toLocalDate().plusDays(1).atTime(LocalTime.MIN);

        System.out.println(localDateTime1.format(dateTimeFormatter));

        LocalDateTime with = now.with(LocalTime.MAX);
        System.out.println(with.format(dateTimeFormatter));

        LocalDateTime zonedDateTime = now.toLocalDate().plusDays(1).atStartOfDay();



        //long between = ChronoUnit.SECONDS.between(now, zonedDateTime);

        LocalDateTime endTime = LocalDateTime.of(2025, 8, 13, 23, 59, 59);

        long between = ChronoUnit.SECONDS.between(endTime, zonedDateTime);

        System.out.println(between);


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

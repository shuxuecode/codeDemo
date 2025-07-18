import com.google.common.collect.Sets;
import org.joda.time.*;
import org.joda.time.format.DateTimeFormat;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashSet;

/**
 * @author
 * @date 2022/6/14
 */
public class UnitTest {


    @Test void t7() {


        Period days = Period.days(2);

        LocalDate localDate = LocalDate.now().plus(days);
        System.out.println(localDate);


        DateTime start = new DateTime("2023-10-01");
        DateTime end = new DateTime("2023-10-05");

        // 计算两个日期的差值（返回 Period 对象）
        Period diff = new Period(start, end);
        System.out.println(diff.getDays());

    }


    @Test void t6(){
        DateTime now = DateTime.now();
        //            int year,
        //            int monthOfYear,
        //            int dayOfMonth,
        //            int hourOfDay,
        //            int minuteOfHour,
        //            int secondOfMinute,
        //            int millisOfSecond
        DateTime dateTime = new DateTime(2025, 7, 15, 12, 12, 12, 0);

        int a = Days.daysBetween(now, dateTime).getDays();
        int b = Days.daysBetween(dateTime, now).getDays();


        System.out.println(a);
        System.out.println(b);
        System.out.println(Math.abs(b));
    }


    @Test void t5(){
        if (LocalDateTime.now().isAfter(LocalDateTime.now())) {
            System.out.println("after");
        } else {
            System.out.println("before");
        }
    }


    @Test void t4(){
        LocalDate day1 = LocalDate.now();

        LocalDate day2 = LocalDate.parse("20221127100000", DateTimeFormat.forPattern("yyyyMMddHHmmss"));

        System.out.println(day1);
        System.out.println(day2);

        System.out.println(day1.equals(day2));
        System.out.println(day1.compareTo(day2));

        System.out.println("20221127100000".substring(0, 8));
        System.out.println(day1.toString(DateTimeFormat.forPattern("yyyyMMdd")));
    }

    @Test
    void t3(){
        LocalDateTime localDateTime = LocalDateTime.now().withMillisOfDay(0);

        localDateTime = localDateTime.minusSeconds(1);

        localDateTime = localDateTime.plusDays(3);

        System.out.println(localDateTime);
    }
    @Test
    void t2(){
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.toDate());

        LocalDate days = localDate.minusDays(2);

        System.out.println(days);
        System.out.println(days.toDate());

    }
    @Test
    void t1(){
        LocalDateTime now = LocalDateTime.now();

        System.out.println(now.withHourOfDay(23).withMinuteOfHour(59).withSecondOfMinute(59));
        System.out.println(now.millisOfDay().withMaximumValue());
    }

}

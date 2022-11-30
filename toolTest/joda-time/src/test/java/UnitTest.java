import com.google.common.collect.Sets;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashSet;

/**
 * @author
 * @date 2022/6/14
 */
public class UnitTest {

    @Test void t5(){

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

import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.junit.jupiter.api.Test;

import java.util.Date;

/**
 * @author
 * @date 2022/6/14
 */
public class UnitTest {

    @Test
<<<<<<< HEAD
=======
    void t3(){
        LocalDateTime localDateTime = LocalDateTime.now().withMillisOfDay(0);

        localDateTime = localDateTime.minusSeconds(1);

        localDateTime = localDateTime.plusDays(3);

        System.out.println(localDateTime);
    }
    @Test
>>>>>>> 71be69ab5cf45e083419c9e7cae2d1848cbc4e3b
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

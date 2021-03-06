import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @date 2022/6/20
 */
public class JavaTest1 {

    @Test
    void t1() {
        int num = 3;
        if (!(num == 1 || num == 2)) {
            System.out.println(123);
        }

    }

    @Test
    void t2() {
        System.out.println(Long.MAX_VALUE); // 9223372036854775807  19位
        System.out.println(Integer.MAX_VALUE); // 2147483647  10位
    }

    @Test
    void t3() {
        System.out.println(Double.parseDouble("12.5"));

        BigDecimal bigDecimal = new BigDecimal(Double.parseDouble("12.5")).multiply(BigDecimal.valueOf(100));
        bigDecimal = bigDecimal.setScale(0, BigDecimal.ROUND_HALF_UP);
        int intValue = bigDecimal.intValue();
        System.out.println(intValue);
    }

    @Test
    void t4() {
        int hashCode = UUID.randomUUID().toString().hashCode();
        if (hashCode < 0) {
            hashCode = -hashCode;
        }
        System.out.println(Long.valueOf(hashCode));
        String format = String.format("%015d", hashCode);
        System.out.println(Long.valueOf(format));
    }

    @Test
    void t5() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.HOUR_OF_DAY, -1); // 24小时制
        //calendar.add(Calendar.HOUR, 1); // 12小时制
        Date date = calendar.getTime();
        System.out.println(date);

        System.out.println(date.before(new Date()));
    }

    @Test
    void t6() {
        int i = 1;
        while (true) {

            if (i % 3 == 0) {
                return;
            }


            System.out.println(i++);

            try {
                TimeUnit.SECONDS.sleep(1L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }
    }

    @Test void t7(){
        System.out.println(new Date());
        System.out.println(LocalDateTime.now().getHour());
        System.out.println(LocalDateTime.of(2022, 7, 18, 24, 0).getHour()); //java.time.DateTimeException: Invalid value for HourOfDay (valid values 0 - 23): 24
    }

    @Test void t8(){
        System.out.println(Long.valueOf(""));
    }
}

import com.test.demo.Demo;
import com.zsx.Person;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    @Test
    void t7() {
        System.out.println(new Date());
        System.out.println(LocalDateTime.now().getHour());
        System.out.println(LocalDateTime.of(2022, 7, 18, 24, 0).getHour()); //java.time.DateTimeException: Invalid value for HourOfDay (valid values 0 - 23): 24
    }

    @Test
    void t8() {
        System.out.println(Long.valueOf(""));
    }

    @Test
    void t9() {
        BigDecimal bigDecimal = new BigDecimal(10000);
        BigDecimal multiply = new BigDecimal("12").multiply(bigDecimal).setScale(0, RoundingMode.DOWN);
        System.out.println(multiply);
        System.out.println(multiply.toString());
        System.out.println(multiply.toPlainString());

        Integer num = 120000;
        Integer num2 = multiply.intValueExact();
        System.out.println(num.equals(num2));
    }

    @Test
    void t10() {
        System.out.println(3 << 1);
        System.out.println(3 << 2);
        System.out.println(3 << 3);

        for (int i = 0; i < 10; i++) {
            System.out.println(i + " : " + (i << 1) + "  " + (i * 2));
        }
    }

    @Test
    void t11() {
        long startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {

        }
        System.out.println("不包含try-catch循环耗时：" + (System.nanoTime() - startTime));


        startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            try {

            } catch (Exception e) {

            }
        }
        System.out.println("包含了try-catch循环耗时：" + (System.nanoTime() - startTime));

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2, 5L, TimeUnit.SECONDS, new SynchronousQueue<>());

        //threadPoolExecutor.allowCoreThreadTimeOut(true);
        boolean b = threadPoolExecutor.allowsCoreThreadTimeOut();
        System.out.println(b); // 默认false

    }

    @RepeatedTest(value = 10000)
    void t12() {

        Person person1 = new Person(1, "a");
        Person person2 = new Person(2, "ab");
        Person person3 = new Person(3, "abc");
        Person person4 = new Person(4, "abcd");
        Person person5 = new Person(5, "abcde");

        ArrayList<Person> list = new ArrayList<>();
        list.add(person1);
        list.add(person2);
        list.add(person3);
        list.add(person4);
        list.add(person5);

        System.out.println(list);

        {
            //Person person = list.get(2);
            //
            //list.add(0, person);
            //
            //System.out.println(list);
            //
            //list.remove(3);
            //
            //System.out.println(list);
        }

        {
            //for (int i = 2; i > 0; i--) {
            //    Collections.swap(list, i, i - 1);
            //}
            //System.out.println(list);
        }

        {
            // 仅替换，不移动
            list.set(0, list.set(2, list.get(0)));
            System.out.println(list);
        }

    }


    @Test
    void t13() {
        String str = "123,124,125,1";
        int index = str.lastIndexOf(",");
        if (index == -1) {

        } else {
            String substr = str.substring(0, index);
            System.out.println(substr);

            String[] split = substr.split(",");
            Arrays.stream(split).forEach(System.out::println);

            for (int i = 0; i < split.length && i < 99; i++) {
                System.out.println(i);
            }
        }
    }

    @Test
    void t14(){
        for (int i = 0; i < 20; i++) {
            System.out.println(new Random().nextInt(10));
        }

    }

    @Test
    void t15(){
        Pattern pattern = Pattern.compile(".*Service");

        Matcher matcher = pattern.matcher("abService");

        System.out.println(matcher);

        System.out.println(matcher.matches());

        System.out.println(Pattern.compile(".*Service").matcher("abServicer").matches());

    }


    @Test
    void t16(){
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTime());
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println(calendar.get(Calendar.MINUTE));

    }
}

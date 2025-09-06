import com.test.demo.Demo;
import com.zsx.Person;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
        // calendar.add(Calendar.HOUR, 1); // 12小时制
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
        System.out.println(LocalDateTime.of(2022, 7, 18, 24, 0).getHour()); // java.time.DateTimeException: Invalid value for HourOfDay (valid values 0 - 23): 24
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

        // threadPoolExecutor.allowCoreThreadTimeOut(true);
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
            // Person person = list.get(2);
            //
            // list.add(0, person);
            //
            // System.out.println(list);
            //
            // list.remove(3);
            //
            // System.out.println(list);
        }

        {
            // for (int i = 2; i > 0; i--) {
            //    Collections.swap(list, i, i - 1);
            //}
            // System.out.println(list);
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
    void t14() {
        for (int i = 0; i < 20; i++) {
            System.out.println(new Random().nextInt(10));
        }

    }

    @Test
    void t15() {
        Pattern pattern = Pattern.compile(".*Service");

        Matcher matcher = pattern.matcher("abService");

        System.out.println(matcher);

        System.out.println(matcher.matches());

        System.out.println(Pattern.compile(".*Service").matcher("abServicer").matches());

    }


    @Test
    void t16() {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTime());
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY)); // 当前小时
        System.out.println(calendar.get(Calendar.MINUTE)); // 当前分钟
        System.out.println(calendar.get(Calendar.SECOND)); // 当前秒

    }

    @Test
    void t17() {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int num = random.nextInt(500);
            int res = num > 100 ? num / 100 * 100 : num / 10 * 10;
            System.out.println(num + " --> " + res);
        }
    }

    @Test
    void t18() {
        List<String> priorityList = new ArrayList<>();
        priorityList.add("1");
        priorityList.add("2");
        priorityList.add("3");
        priorityList.add("4");
        priorityList.add("5");


        List<String> list = new ArrayList<>();
        list.add("7");
        list.add("4");
        list.add("9");
        list.add("1");

        // 根据配置优先级进行排序
        Collections.sort(list, (a, b) -> {
            int indexA = priorityList.indexOf(a);
            int indexB = priorityList.indexOf(b);
            indexA = indexA == -1 ? 99 : indexA;
            indexB = indexB == -1 ? 99 : indexB;
            return Integer.compare(indexA, indexB);
        });

        list.stream().forEach(System.out::println);
    }


    @Test
    void t19() {

        try {
            Class<?> clz = Class.forName("com.zsx.util.DataUtil");

            Method method = clz.getMethod("getData");

            Object obj = clz.getDeclaredConstructor().newInstance();

            Object invoke = method.invoke(obj);

            System.out.println(invoke);
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }


    @Test
    void t20() {
        // 原始时间字符串
        String originalTimeString = "2024-07-08 14:14:49:819";

        // 定义输入格式
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

        // 解析时间字符串
        LocalDateTime time = LocalDateTime.parse(originalTimeString, inputFormatter);

        // 定义输出格式
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("HHmmssSSS");

        // 格式化时间
        String formattedTime = time.format(outputFormatter);

        // 输出结果
        System.out.println(formattedTime);
        System.out.println(Integer.parseInt(formattedTime));
    }

    @Test
    void t21() {
        LocalDateTime now = LocalDateTime.now();
        now = now.withMinute(0).withSecond(0).withNano(0);
        System.out.println(now);
        System.out.println(now.minusHours(2)); // 减2小时
        System.out.println(now.minus(Duration.ofHours(2))); // 减2小时

    }

    @Test
    void t22() {
        // 如果命中其中一个，则命中
        // 第二个方法不会执行
        if (t221() || t222()) {
            System.out.println("命中");
        }

    }

    private static boolean t221() {
        System.out.println("第一个boolean");
        return true;
    }
    private static boolean t222() {
        System.out.println("第二个boolean");
        return true;
    }



    @Test
    void t23() {

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");

        List<String> collect = list.stream().map(item -> {
            if (item.equals("2")) {
                return null;
            }
            return item + "1";
        })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        System.out.println(collect); // [11, 31, 41]

    }



    @Test
    void t24() throws InterruptedException {

        CompletableFuture.runAsync(() -> {
            System.out.println("hello");

            CompletableFuture.runAsync(() -> {
                System.out.println("world");
            });
        });



        TimeUnit.SECONDS.sleep(5);
    }

    @Test
    void t25() {

        int availableProcessors = Runtime.getRuntime().availableProcessors();

        System.out.println(availableProcessors);

    }
}

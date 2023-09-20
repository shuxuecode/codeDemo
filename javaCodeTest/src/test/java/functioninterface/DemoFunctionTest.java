package functioninterface;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Supplier<T> 无参数  返回T  供给型；无参，返回一个指定泛型的对象
 * Consumer<T>  T     无返回  消费型
 * Predicate<T> T    Boolean 断言型；判断函数，返回判断结果true/false
 * Function<T,R> T     返回R  方法型；
 *
 * @author
 * @date 2022/6/12
 */
class DemoFunctionTest {

    @Test
    void test1() {
        DemoFunction.isTrue(true).test("True");


    }

    @Test
    void t2() {
        Function<String, String> function = str -> str + "2020";

        String res = function.apply("a");

        System.out.println(res);

        // 输入String，输出Integer
        Function<String, Integer> fun = x -> Integer.parseInt(x);
        Integer r = fun.apply("123");
        System.out.println(r);
    }

    @Test
    void t3() {

        String test = test(() -> {
            return "123";
        });

        test = test(() -> "abc");

        System.out.println(test);

    }

    // todo zsx
    <T> T test(Supplier<T> call) {
        return call.get();
    }


    @Test
    void t4() {
        Supplier<Integer> a = () -> 1 + 2;
        int c = a.get() + 3; // a 只有在这一行使用时才会计算
        System.out.println(c);
    }

    @Test
    void t5() {
        /*
        Consumer接口是一个消费型的接口，只要实现它的accept方法，就能作为消费者来输出信息。
        lambda、方法引用都可以是一个Consumer类型，因此他们可以作为forEach的参数，用来协助Stream输出信息。
         */
        Consumer<String> consumer = (a) -> System.out.println(a);

        consumer.accept("hello world!!!");

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Consumer<Integer> consumer1 = System.out::println;
        list.stream().forEach(consumer1);

        Consumer<Integer> consumer2 = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("实现方法");
            }
        };

        consumer2.accept(123);
    }

    @Test
    void t6() {
        Predicate<String> predicate = (i) -> i != null;

        boolean test = predicate.test("1");
        System.out.println(test);

        System.out.println(predicate.test(null));
    }

    @Test
    void t7() {
        // andThen
        Function<Integer, Integer> fun1 = a -> a + 2;
        Function<Integer, Integer> fun2 = a -> a * 2;
        // (1 + 2) * 2
        Function<Integer, Integer> fun3 = fun1.andThen(fun2);
        Integer res = fun3.apply(1);
        System.out.println(res);
    }

    @Test
    void t8() {
        Function<Integer, Integer> fun1 = a -> a + 2;
        Function<Integer, Integer> fun2 = a -> a * 2;
        // (1 * 2) + 2
        Function<Integer, Integer> fun3 = fun1.compose(fun2);
        Integer res = fun3.apply(1);
        System.out.println(res);
    }




}
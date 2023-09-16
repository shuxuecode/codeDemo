package functioninterface;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
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
}
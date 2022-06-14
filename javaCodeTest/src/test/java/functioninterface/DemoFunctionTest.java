package functioninterface;

import org.junit.jupiter.api.Test;

import java.util.function.Function;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

/**
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


}
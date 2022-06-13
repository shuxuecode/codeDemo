package functioninterface;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

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
}
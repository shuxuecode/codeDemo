package tool.test;

import com.test.object.ObjDemo;
import org.junit.jupiter.api.Test;

import java.util.Objects;

/**
 * @date 2022/4/25
 */
public class ObjectTest {


    @Test
    void t1() {
        t2();
    }

    private void t2() {
        ObjDemo demo = null;

        test(demo);

        System.out.println(demo.getName()); // java.lang.NullPointerException
        System.out.println(demo.getAge());
    }

    private void test(ObjDemo demo) {
        demo = new ObjDemo();
        demo.setAge(12);
        demo.setName("test");
    }
}

package tool.guava;

import com.google.common.base.Strings;
import org.junit.jupiter.api.Test;

import java.util.Date;

/**
 * @date 2022/9/29
 */
public class StringsTest {



    @Test void t4(){

        String str = "123\n" +
                "456\n" +
                "789";

        String[] split = str.trim().split("\n");
        for (String s : split) {
            System.out.println(s);
        }

    }

    @Test void t3(){
        String format = Strings.lenientFormat("测试%s 数字%s  空是 %s  日期%s", "abc", 123, null, new Date());
        System.out.println(format);
    }

    @Test void t2(){
        System.out.println(Strings.commonPrefix("abcdefg", "abcd123")); // abcd
    }

    @Test void t1(){
        String padStart = Strings.padStart("10", 5, '0');
        System.out.println(padStart);

        for (int i = 1; i <= 12; i++) {
            System.out.println(Strings.padStart(String.valueOf(i), 2, '0'));
        }
    }
}

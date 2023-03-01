package com.zsx;

import com.google.common.collect.ImmutableMap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @date 2023/2/24
 */
class GroovyUtilsTest {

    static String str = "\n";

    @Test
    void t1() {
        StringBuilder script = new StringBuilder();
        script.append("package groovy\n").append(str);
        script.append("def test() {").append(str);
        script.append("println(\"test\")").append(str);
        script.append("").append(str);
        script.append("").append(str);
        script.append("}");

        System.out.println(script.toString());

        GroovyUtils.invoke(script.toString(), "test", null);
    }

    @Test
    void t2() {
        String str = "package groovy\n" +
                "def check(int score) {\n" +
                "            if (0 <= score && score < 10) {\n" +
                "                return \"小于10\";\n" +
                "            } else if (10 <= score && score < 100) {\n" +
                "                return \"大于10\";\n" +
                "            } else {\n" +
                "                return \"默认\";\n" +
                "            }\n" +
                "        }";


        Object res = GroovyUtils.invoke(str.toString(), "check", 500);
        System.out.println(res);
    }

    @Test
    void t3() {
        String str = "def calculate(int a, int b, String c) {\n" +
                "    return c + (a + b)\n" +
                "}";
        String res = GroovyUtils.invoke(str, "calculate", new Object[]{1, 2, "res="});
        System.out.println(res);
    }

}
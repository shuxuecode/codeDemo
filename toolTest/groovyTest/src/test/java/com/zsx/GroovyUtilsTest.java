package com.zsx;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import groovy.lang.Script;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

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

    @Test
    void t4() {
        String str = "import java.util.Date;" +
                "    return c + (a + b) + new Date()" +
                "";
        str = "import com.google.common.collect.Lists;" +
                "            if (0 <= score && score < 10) {\n" +
                "                return \"小于10\";\n" +
                "            } else if (10 <= score && score < 100) {\n" +
                //" return Maps.newConcurrentMap();" +
                " return Lists.newArrayList(1,2,3); " +
                //"                return \"大于10\";\n" +
                "            } else {\n" +
                "                return \"默认\";\n" +
                "            }\n";
        GroovyShell shell = new GroovyShell();
        Script script = shell.parse(str);

        HashMap<@Nullable Object, @Nullable Object> map = Maps.newHashMap();
        //map.put("a", 1);
        //map.put("b", 2);
        //map.put("c", "");
        map.put("score", 20);
        Binding binding = new Binding(map);
        script.setBinding(binding);

        Object res = script.run();

        System.out.println(res);

    }
}
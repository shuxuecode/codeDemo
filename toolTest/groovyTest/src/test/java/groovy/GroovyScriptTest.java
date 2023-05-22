package groovy;

import com.google.common.collect.ImmutableMap;
import com.zsx.GroovyUtils;
import groovy.lang.GroovyShell;
import groovy.lang.Script;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @date 2023/2/23
 */
public class GroovyScriptTest {

    @Test
    void t1() {

        GroovyShell shell = new GroovyShell();

        Script script = shell.parse("package groovy\n" +
                "def Hello(){ println(\"Hello test\")}"
        );

        Object res = script.invokeMethod("Hello", null);
    }

    @Test
    void t2() {

        GroovyShell shell = new GroovyShell();

        Script script = shell.parse("package groovy\n" +
                "\n" +
                "import com.google.common.collect.Lists;\n" +
                "\n" +
                "/**\n" +
                " * 静态变量\n" +
                " */\n" +
                "class Globals {\n" +
                "    static String str = \"abc\";\n" +
                "}\n" +
                "\n" +
                "\n" +
                "def Test01() {\n" +
                "\n" +
                "    def list = Lists.newArrayList(\"1\", \"2\", \"3\")\n" +
                "\n" +
                "    return list;\n" +
                "\n" +
                "}"
        );

        Object res = script.invokeMethod("Test01", null);
        System.out.println(res instanceof ArrayList);
        System.out.println(res);
    }

    @Test
    void t3() {
        String script = "class Global {\n" +
                "    static Map<String, Object> hashMap = [\n" +
                "            \"a\": [\n" +
                "                    \"A\": 1,\n" +
                "                    \"B\": 2,\n" +
                "                    \"C\": 3\n" +
                "            ],\n" +
                "            \"b\": [\n" +
                "                    \"A\": 5,\n" +
                "                    \"B\": 6,\n" +
                "                    \"C\": 7\n" +
                "            ]\n" +
                "    ]\n" +
                "}\n" +
                "\n" +
                "def run(Object map) {\n" +
                "println(map instanceof Map)\n" +
                "    println(map instanceof List)\n" +
                "    println(map)\n" +
                "\n" +
                "    HashMap res = []\n" +
                "\n" +
                "    for (entry in map) {\n" +
                "\n" +
                "        def value = Global.hashMap.get(entry.key)\n" +
                "\n" +
                "        res[entry.key] = value[entry.value]\n" +
                "    }\n" +
                "\n" +
                "    return res\n" +
                "}\n";


        GroovyShell shell = new GroovyShell();
        Script parse = shell.parse(script);

        Object res = parse.invokeMethod("run", new Object[]{ImmutableMap.of("a", "A", "b", "C")});
        System.out.println(res);
        System.out.println(res instanceof HashMap);
        Map result = (Map) res;
        System.out.println(result);
        System.out.println(result.get("a"));

        HashMap invoke = GroovyUtils.invoke(script, "run", new Object[]{ImmutableMap.of("a", "A", "b", "C")});
        System.out.println(invoke);
    }


    @Test
    void t5() {
        GroovyShell shell = new GroovyShell();
        Script parse = shell.parse("a/b");
        parse.run();
    }

}

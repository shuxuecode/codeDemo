package groovy;

import groovy.lang.GroovyShell;
import groovy.lang.Script;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * @date 2023/2/23
 */
public class GroovyScriptTest {

    @Test void t1(){

        GroovyShell shell = new GroovyShell();

        Script script = shell.parse("package groovy\n" +
                "def Hello(){ println(\"Hello test\")}"
        );

        Object res = script.invokeMethod("Hello", null);
    }

    @Test void t2(){

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



}

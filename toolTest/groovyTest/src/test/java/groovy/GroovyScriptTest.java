package groovy;

import groovy.lang.GroovyShell;
import groovy.lang.Script;
import org.junit.jupiter.api.Test;

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




}

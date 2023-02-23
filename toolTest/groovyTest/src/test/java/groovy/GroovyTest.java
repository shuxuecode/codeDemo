package groovy;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import groovy.lang.Script;
import org.codehaus.groovy.control.CompilerConfiguration;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 * @date 2023/2/21
 */
public class GroovyTest {


    @Test
    void t1() {
        GroovyShell shell = new GroovyShell();
        Object res = shell.evaluate("(1/2) + 1");
        System.out.println(res);
    }


    @Test
    void t2() {
        Binding binding = new Binding();
        binding.setVariable("a", 2000);
        binding.setVariable("b", 100);
        binding.setVariable("c", new BigDecimal("0.8"));
        binding.setVariable("d", new BigDecimal("2.2"));

        binding.setVariable("h", 10);
        binding.setVariable("i", new BigDecimal("1.5"));
        binding.setVariable("j", new BigDecimal("9"));

        GroovyShell shell = new GroovyShell(binding);
        Object res = shell.evaluate("(a/30*b*c*d)/(h+i-0.5*j)");
        System.out.println(res);

    }


    @Test
    void t3() {
        Binding binding = new Binding();
        binding.setVariable("a", 2000);
        binding.setVariable("b", 100);
        binding.setVariable("c", new BigDecimal("0.8"));
        binding.setVariable("d", new BigDecimal("2.2"));

        binding.setVariable("h", 10);
        binding.setVariable("i", new BigDecimal("1.5"));
        binding.setVariable("j", new BigDecimal("9"));


        CompilerConfiguration cfg = new CompilerConfiguration();
        cfg.setScriptBaseClass(EvalBaseScript.class.getTypeName());

        GroovyShell shell = new GroovyShell(binding, cfg);

        //Script script = shell.parse("(round((a/30), 2)*b*c*d)/(h+i-0.5*j)");
        Script script = shell.parse("round((round((a/30), 2)*b*c*d)/(h+i-0.5*j), 2)");

        Object res = script.run();
        System.out.println(res);

        // todo zsx
        shell.resetLoadedClasses();
    }

}

package com.zsx;

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

}
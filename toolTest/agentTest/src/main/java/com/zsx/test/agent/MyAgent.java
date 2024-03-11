package com.zsx.test.agent;

import java.lang.instrument.Instrumentation;

/**
 * @date 2024/3/11
 */
public class MyAgent {

    public static void premain(String agentArgs, Instrumentation instrumentation) {
        System.out.println("premain方法");
        instrumentation.addTransformer(new MyClassTransformer(), true);
    }
}

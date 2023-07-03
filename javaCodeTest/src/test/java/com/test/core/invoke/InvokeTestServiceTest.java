package com.test.core.invoke;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @date 2023/7/3
 */
public class InvokeTestServiceTest {




    @Test void t1() {
        test();
    }


    public void test() {
        TestService testService = new TestService();
        try {
            Method method = TestService.class.getMethod("getUUID", String.class);
            Object res = method.invoke(testService, "_123");
            System.out.println(res);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


}

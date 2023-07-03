package com.test.core.invoke;

import org.junit.jupiter.api.Test;

import java.lang.invoke.*;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @date 2023/7/3
 */
public class LambdaMetafactoryTest {


    @Test
    void t2() {
        MethodHandles.Lookup lookup = MethodHandles.lookup();

        MethodType methodType = MethodType.methodType(String.class, String.class);

        try {
            MethodHandle methodHandle = lookup.findVirtual(TestService.class, "getUUID", methodType);
            MethodType func = methodHandle.type();

            CallSite callSite = LambdaMetafactory.metafactory(lookup,
                    "getUUID",
                    MethodType.methodType(MetadataFunction.class),
                    func.generic(),
                    methodHandle,
                    func
            );

            MethodHandle factory = callSite.getTarget();

            MetadataFunction function = (MetadataFunction) factory.invoke();
            Object apply = function.apply("——123");
            System.out.println(apply);


        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    void t1() {
        test();
    }

    private Map<String, MetadataFunction> metadataFunctionMap = new ConcurrentHashMap<>();

    public void test() {
        TestService testService = new TestService();
        String className = testService.getClass().getName();
        System.out.println(className);
        String methodName = "getUUID";
        MetadataFunction function = metadataFunctionMap.get(methodName);
        if (function == null) {
            function = buildMetadataFunction(className, methodName);
            metadataFunctionMap.put(methodName, function);
        }

        Object res = function.apply("-123");
        System.out.println(res);
    }


    public MetadataFunction buildMetadataFunction(final String className, final String methodName) {


        MethodHandles.Lookup lookup = MethodHandles.lookup();

        try {
            Class<?> clazz = Class.forName(className);
            Method method = clazz.getDeclaredMethod(methodName, String.class);

            MethodHandle methodHandle = lookup.unreflect(method);

            MethodType methodType = methodHandle.type();

            CallSite callSite = LambdaMetafactory.metafactory(lookup,
                    "apply",
                    MethodType.methodType(MetadataFunction.class, methodType.parameterType(0)),
                    methodType,
                    methodHandle,
                    methodType
            );

            return (MetadataFunction) callSite.getTarget().invoke();

        } catch (LambdaConversionException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}

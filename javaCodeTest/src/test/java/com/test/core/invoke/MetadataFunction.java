package com.test.core.invoke;

/**
 * @date 2023/7/3
 */
@FunctionalInterface
public interface MetadataFunction<T, S, R> {
    R apply(S s);
}

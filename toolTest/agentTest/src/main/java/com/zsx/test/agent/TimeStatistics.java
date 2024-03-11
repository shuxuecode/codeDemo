package com.zsx.test.agent;

/**
 * @date 2024/3/11
 */
public class TimeStatistics {
    public static ThreadLocal<Long> time = new ThreadLocal<>();

    public static void start() {
        time.set(System.currentTimeMillis());
    }

    public static void end() {
        long t = System.currentTimeMillis() - time.get();
        System.out.println(Thread.currentThread().getStackTrace()[2] + " cost " + t + "ms");
    }
}

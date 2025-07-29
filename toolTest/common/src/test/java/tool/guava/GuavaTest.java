package tool.guava;

import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.RateLimiter;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

/**
 * @date 2022/9/26
 */
public class GuavaTest {

    @Test
    void t1(){
        RateLimiter rateLimiter = RateLimiter.create(1, 1, TimeUnit.SECONDS);
        System.out.println(rateLimiter.acquire(1)); // 0.0
        System.out.println(rateLimiter.acquire(1)); // 1.498491
        System.out.println(rateLimiter.acquire(1)); // 0.992319
        System.out.println(rateLimiter.acquire(1)); // 0.995078

        double rate = rateLimiter.getRate();
        System.out.println(rate);

        rateLimiter.setRate(5);

        System.out.println(rateLimiter.acquire(1));
        System.out.println(rateLimiter.acquire(1));
        System.out.println(rateLimiter.acquire(1));
        System.out.println(rateLimiter.acquire(1));

        rate = rateLimiter.getRate();
        System.out.println(rate);

    }
}

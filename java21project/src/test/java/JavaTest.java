import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class JavaTest {


    @Test
    public void t() {

        // 创建虚拟线程
        try (ExecutorService taskExecutor = Executors.newVirtualThreadPerTaskExecutor()) {

            for (int i = 0; i < 10; i++) {
                int finalI = i;
                taskExecutor.submit(() -> {
                    TimeUnit.MILLISECONDS.sleep(500L);
                    System.out.println(finalI);
                    return finalI;
                });
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }


    @Test
    void t2() {
        // 创建虚拟线程，默认不启动
        Thread thread = Thread.ofVirtual().name("test").unstarted(() -> {
            System.out.println("test");
        });

        thread.start();

        // 创建虚拟线程
        Thread.ofVirtual().name("test2").start(() -> {
            System.out.println("test2");
        });
    }

}

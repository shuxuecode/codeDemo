package queue.delay;

import com.sun.tools.corba.se.idl.StringGen;
import org.junit.jupiter.api.Test;

import java.security.PublicKey;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @date 2022/7/8
 */
public class TaskTest {

    public static DelayQueue<DelayTask<String>> delayQueue = new DelayQueue<>();

    @Test
    void t1() {


    }

    public void process() {
        while (true) {

            try {
                DelayTask<String> take = delayQueue.take();
                if (take != null) {
                    // 拿到业务数据

                    String task = take.getTask();

                }

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            try {
                // 防止cpu一直不停的做事，导致cpu耗的很高
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}

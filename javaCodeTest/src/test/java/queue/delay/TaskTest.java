package queue.delay;

import org.junit.jupiter.api.Test;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @date 2022/7/8
 */
public class TaskTest {

    public static DelayQueue<DelayTask<TaskDemo>> delayQueue = new DelayQueue<>();

    @Test
    void t1() {

        ExecutorService executorService = Executors.newFixedThreadPool(1);

        executorService.submit(() -> {
            process();
        });


        for (int i = 0; i < 10; i++) {
            TaskDemo taskDemo = new TaskDemo();
            taskDemo.setName("延迟" + i + "秒");


            DelayTask<TaskDemo> taskDemoDelayTask = new DelayTask<>(taskDemo, i * 1000);

            //delayQueue.put(taskDemoDelayTask);
            //delayQueue.offer(taskDemoDelayTask);
            //boolean offer = delayQueue.offer(taskDemoDelayTask, 10, TimeUnit.SECONDS);
            TaskTest.delayQueue.offer(taskDemoDelayTask);
        }

        try {
            TimeUnit.SECONDS.sleep(15);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void process() {
        while (true) {

            try {
                DelayTask<TaskDemo> take = delayQueue.take();
                if (take != null) {
                    // 拿到业务数据
                    TaskDemo taskDemo = take.getTask();
                    taskDemo.getName();
                    System.out.println(System.currentTimeMillis() + " - " + taskDemo.getName());
                }

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(System.currentTimeMillis());
            System.out.println();
            //try {
            //    // 防止cpu一直不停的做事，导致cpu耗的很高
            //    TimeUnit.MILLISECONDS.sleep(50);
            //} catch (InterruptedException e) {
            //    throw new RuntimeException(e);
            //}

        }
    }
}

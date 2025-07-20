package queue.delay;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 1、功能概述：
 * 封装一个任务（T task）和延迟时间（long time），用于在延迟队列中执行。
 * 实现了 Delayed 接口，支持任务按延迟时间排序和计算剩余延迟时间。
 * <p>
 * 2、关键方法：
 * compareTo(Delayed o)：比较两个任务的延迟时间，用于排序。
 * getDelay(TimeUnit unit)：返回任务剩余的延迟时间。
 * <p>
 * 3、使用场景：
 * 适用于需要延迟执行任务的场景，如定时任务调度、消息队列延迟投递等。
 *
 * @date 2022/7/8
 */
public class DelayTask<T> implements Delayed {

    /**
     * 延时的时间，单位毫秒
     */
    private long time;

    /**
     * 任务类
     */
    private T task;

    public DelayTask(T task, long time) {
        super();
        this.task = task;
        // 过期时间为当前时间加上延迟时间
        this.time = System.currentTimeMillis() + time;
    }

    public DelayTask() {
    }


    @Override
    public int compareTo(Delayed o) {
        long time = getDelay(TimeUnit.NANOSECONDS) - o.getDelay(TimeUnit.NANOSECONDS);
        return time == 0 ? 0 : ((time < 0) ? -1 : 1);
    }


    @Override
    public long getDelay(TimeUnit unit) {
        System.out.println("getDelay");
        return unit.convert(this.time - System.currentTimeMillis(), unit);
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public T getTask() {
        return task;
    }

    public void setTask(T task) {
        this.task = task;
    }
}

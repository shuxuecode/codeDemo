package queue.delay;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
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

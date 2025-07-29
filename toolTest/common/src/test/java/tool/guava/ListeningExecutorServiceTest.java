package tool.guava;

import com.google.common.util.concurrent.*;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


/**
 *
 * ListeningExecutorService 是Guava对Java标准库ExecutorService的扩展，
 * 1、支持回调机制：不再需要手动get()等待结果，任务完成后自动触发回调
 * 2、返回ListenableFuture：支持链式操作
 * 3、更灵活的异步组合：轻松合并多个异步任务，处理超时、异常等场景。
 *
 * @date 2022/9/26
 */

public class ListeningExecutorServiceTest {




    @Test void t1(){

        ExecutorService executorService = Executors.newFixedThreadPool(8);

        ListeningExecutorService listeningExecutorService = MoreExecutors.listeningDecorator(executorService);


        ListenableFuture<?> future = listeningExecutorService.submit(() -> {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {

            }
            System.out.println("hello world");
        });

        Futures.addCallback(future, new FutureCallback<Object>() {
            @Override
            public void onSuccess(Object result) {
                System.out.println("Task success");
            }
            @Override
            public void onFailure(Throwable t) {
                System.out.println("Task fail");
            }
        }, MoreExecutors.directExecutor());


        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }





}

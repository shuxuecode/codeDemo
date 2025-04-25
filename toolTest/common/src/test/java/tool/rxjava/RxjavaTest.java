package tool.rxjava;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.observers.TestObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * 在当前Java开发领域，异步编程已成为提高应用性能、响应能力和扩展性的重要方法之一。
 * RxJava 是一种基于观察者模式的Java虚拟机实现，旨在通过异步和事件驱动的方式构建应用程序。
 * 它不仅简化了异步和事件驱动编程，并且通过提供丰富多样的操作符来处理数据流，增强了其功能性和灵活性。
 */
public class RxjavaTest {


    @Test
    void test01() {

        // 创建一个Observable，模拟异步操作
        Observable<Integer> observable = Observable.fromIterable(Arrays.asList(1, 2, 3))
                .subscribeOn(Schedulers.io()) // 指定Observable在IO线程上执行
                .observeOn(Schedulers.single()) // // 指定Observer在单线程上接收数据
                .map(item -> {
                    TimeUnit.SECONDS.sleep(2L);
                    return item + 1;
                });

        // 订阅Observable，并处理接收到的数据
        Disposable complete = observable.subscribe(
                result -> System.out.println(result),// 接收到的数据
                error -> error.printStackTrace(), // 错误处理
                () -> System.out.println("complete")// 完成通知
        );



        // 主线程可以继续执行其他任务，无需等待Observable完成

        System.out.println("end");

        try {
            TimeUnit.SECONDS.sleep(10L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    @Test
    void test02() {

        Single<Integer> single = Single.fromCallable(() -> {
            TimeUnit.SECONDS.sleep(1L);
            return 1;
        }).subscribeOn(Schedulers.io());


        TestObserver<Integer> testObserver = single.test();

        testObserver.awaitDone(3, TimeUnit.SECONDS);

        testObserver
                .assertComplete()
                .assertNoErrors()
                .assertValue(res -> res == 1);


    }

}

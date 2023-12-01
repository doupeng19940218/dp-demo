package org.example.thread;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.TtlRunnable;
import lombok.Data;
import lombok.ToString;

import java.util.concurrent.*;

/**
 * @author walker.dou
 */
public class TransmittableThreadLocalTest {

    public final static TransmittableThreadLocal<InnerObject> inheritableThreadLocal = new TransmittableThreadLocal<>();
    public static final int CORE_THREAD_SIZE = 1;

    public static ExecutorService executorService = Executors.newFixedThreadPool(1);

    public static void main(String[] args) throws InterruptedException {


        final InnerObject innerObject = new InnerObject();
        innerObject.setName("dp1");
        inheritableThreadLocal.set(innerObject);
        final Thread thread = new Thread(TtlRunnable.get(
                () -> {
                    System.out.println(Thread.currentThread().getName() + "1 obtain inheritableThreadLocal in threadPool: " + inheritableThreadLocal.get());
                }));
        thread.start();
//        innerObject.setName("dp2");
//        inheritableThreadLocal.set(innerObject);
//        executorService.submit(
//                () -> System.out.println(Thread.currentThread().getName() + "2 obtain inheritableThreadLocal in threadPool: " + inheritableThreadLocal.get())
//
//        );
//
//        inheritableThreadLocal.set("main thread-3");
//        executorService.submit(TtlRunnable.get(
//                        () -> System.out.println("3 obtain inheritableThreadLocal in threadPool: " + inheritableThreadLocal.get())
//                )
//        );
//
//        inheritableThreadLocal.set("main thread-4");
//        executorService.submit(TtlRunnable.get(
//                        () -> System.out.println("4 obtain inheritableThreadLocal in threadPool: " + inheritableThreadLocal.get())
//                )
//        );

    }

    @Data
    @ToString
    public static class InnerObject {
        String name;
    }
}

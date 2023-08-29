package org.example.other;

import sun.misc.Signal;

import java.util.concurrent.TimeUnit;

/**
 * @author walker.dou
 */
public class SignalHandler {
//    public static void main(String[] args) throws InterruptedException {
//
//        Signal sig = new Signal("INT"); // kill -2 ${pid}
//        Signal.handle(sig, (s) -> {
//            System.out.println("Signal handle start");
//            try {
//                TimeUnit.SECONDS.sleep(3); // 模拟善后逻辑，阻塞3秒
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("Signal handle end");
//            System.exit(0); // 这里显示调用 exit 退出程序，如果不调用，JVM 实例不会退出，这段逻辑就相当于一个普通的信号处理器
//        });
//        Thread.sleep(6000000);
//    }



    public static void main(String[] args) throws InterruptedException {

        // 注册 shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("shutdownHook start");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("shutdownHook end");
        }));
        for (int i = 0; i <= 5; i++) {
            if (i == 5) {
                throw new OutOfMemoryError("123");
            }
            Thread.sleep(1000);
            System.out.println("processing...");
        }
    }



}

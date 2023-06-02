package org.example.other;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author walker.dou
 */
public class MainTest {

    public static void main(String[] args) throws InterruptedException {

        List<Callable<Void>> tasks = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            tasks.add(() -> {
                System.out.println("callable " + finalI);
                Thread.sleep(500);
                return null;
            });
        }

        ExecutorService executor = Executors.newFixedThreadPool(2);
        Thread executorInvokerThread = new Thread(() -> {
            try {
                executor.invokeAll(tasks);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("invokeAll returned");
        });
        executorInvokerThread.start();
        Thread.sleep(800L);
        System.out.println("shutdown");
        executor.shutdownNow();
        System.out.println("shutdown complete");
    }
}
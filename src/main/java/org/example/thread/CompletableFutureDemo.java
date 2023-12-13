package org.example.thread;

import lombok.SneakyThrows;

import java.util.concurrent.CompletableFuture;

/**
 * @author walker.dou
 */
public class CompletableFutureDemo {
    @SneakyThrows
    public static void main(String[] args) {
        final CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> {
            return 1 / 0;
        });
        integerCompletableFuture.exceptionally(a -> {
            System.out.println(a.getMessage());
            return null;
        });
        final CompletableFuture<Void> voidCompletableFuture = integerCompletableFuture.thenAccept(a -> {
            System.out.println("123");
            System.out.println(a);
        });
        voidCompletableFuture.exceptionally(a -> {
            System.out.println(a.getMessage());
            return null;
        });

//        final Integer integer = integerCompletableFuture.get();
//        System.out.println(integer);
    }
}

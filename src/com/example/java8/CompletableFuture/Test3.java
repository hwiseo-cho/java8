package com.example.java8.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Test3 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            System.out.println("hello " + Thread.currentThread().getName());
            return "hello";
        });

        hello.thenCompose(Test3::getWorld);

        System.out.println(hello.get());
    }

    private static CompletableFuture<String> getWorld(String msg) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("world " + Thread.currentThread().getName());
            return msg + " world";
        });
    }
}

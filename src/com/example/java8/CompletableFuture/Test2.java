package com.example.java8.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Object> futures = new CompletableFuture<>();
        futures.complete("hwiseo");

        System.out.println(futures.get());

        CompletableFuture<Void> futures2 = CompletableFuture.runAsync(() -> {
            System.out.println("hello");
        });

        CompletableFuture<String> futures3 = CompletableFuture.supplyAsync(() -> {
            System.out.println("hello2");
            return "Hello";
        });

        System.out.println(futures3.get());

        CompletableFuture<String> futures4 = CompletableFuture.supplyAsync(() -> {
            return "Hello";
        }).thenApply((s) -> {
            return s.toUpperCase();
        });

        System.out.println(futures4.get());

    }
}

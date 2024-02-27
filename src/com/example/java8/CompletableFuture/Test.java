package com.example.java8.CompletableFuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Test {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // Executors
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            System.out.println("Thread " + Thread.currentThread().getName());
            System.out.println("-------------------------------");
        });

        executorService.shutdown();

        ExecutorService executorService2 = Executors.newFixedThreadPool(2);
        executorService2.submit(() -> System.out.println("Thread " + Thread.currentThread().getName()));
        executorService2.submit(() -> System.out.println("Thread " + Thread.currentThread().getName()));
        executorService2.submit(() -> System.out.println("Thread " + Thread.currentThread().getName()));

        executorService2.shutdown();


        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleWithFixedDelay(() -> System.out.println("Thread " + Thread.currentThread().getName()), 1, 2, TimeUnit.SECONDS);

        scheduledExecutorService.shutdown();

        // Future, Callable
        Callable<String> hello = () -> {
            return "hello";
        };

        ExecutorService executorService4 = Executors.newSingleThreadExecutor();
        Future<String> submit = executorService4.submit(hello);

        System.out.println(submit.get());
        System.out.println(submit.isDone());

        Callable<String> hello2 = () -> {
            return "hello2";
        };
        Callable<String> hello3 = () -> {
            return "hello3";
        };
        Callable<String> hello4 = () -> {
            return "hello4";
        };

        // 모두가 끝날 때 까지 기다리고 뿌림
        List<Future<String>> futures = executorService4.invokeAll(Arrays.asList(hello, hello2, hello3, hello4));
        futures.forEach((a) -> {
            try {
                System.out.println(a.get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
    }
}

package com.example.java8.CompletableFuture;

public class Com {

    public static void main(String[] args) {
        // 1.
        MyThread myThread = new MyThread();
        myThread.start();

        // 2.
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread.start();

        System.out.println("Hello");
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Finish");
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Thread: "+ Thread.currentThread().getName());
        }
    }
}

package com.inayath.multithreading;

public class Program1 {

    public static void main(String[] args) throws InterruptedException {

        Thread t1=new Thread(()->{
            System.out.println("Current thread is:"+Thread.currentThread().getName());
            System.out.println("Current threa priority is:"+Thread.currentThread().getPriority());
            throw new RuntimeException("internal excetion");
        });

        t1.setName("MyThread");
        t1.setPriority(Thread.MAX_PRIORITY);   // min -1, norm -5, max -10

        System.out.println("Current thread before starting new thread: "+Thread.currentThread().getName());


        t1.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                //clean up the resources or
                //Inspect with more debug logs to troubleshoot the issue.
                System.out.println("A critical error happend in a thread: "+t.getName()+" with the error: "+e.getMessage());
            }
        });

        t1.start();


        System.out.println("Current thread After starting new thread "+Thread.currentThread().getName());


    }
}

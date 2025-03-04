package com.inayath;

public class LambdaOverhead {
    public static void main(String[] args) {
        // Create a lambda expression that captures a variable
        Runnable r = () -> {
            System.out.println("Hello, world!");
        };

        // Create a new instance of the lambda expression each time it is called
        for (int i = 0; i < 10; i++) {
            r.run();
        }

        long a =System.nanoTime();

        System.out.println(a);
        // Create a new instance of the lambda expression with a captured variable
        Runnable r2 = () -> {
            System.out.println("Hello, world!");
        };

        // Create a new instance of the lambda expression with a captured variable each time it is called
        for (int i = 0; i < 10; i++) {
            r2.run();
        }
        long b = System.nanoTime();
        System.out.println(b);

        System.out.println(a-b);
    }


}

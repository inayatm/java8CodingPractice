package com.inayath;

public class LambdaSingletonTest {

    public static void main(String[] args) {

        Runnable r1 = ()-> System.out.println("hello world");
        Runnable r2 = ()-> System.out.println("hello world");

        System.out.println(r1 == r2);  //false

    }
}

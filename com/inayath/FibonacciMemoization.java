package com.inayath;

import java.util.HashMap;
import java.util.Map;

public class FibonacciMemoization {

    // Map to store previously computed Fibonacci numbers
    private static Map<Integer, Integer> memo = new HashMap<>();


    // Recursive method with memoization to calculate the nth Fibonacci number
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        // Check if the result is already computed
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        // Compute the Fibonacci number and store it in the map
        int result = fibonacci(n - 1) + fibonacci(n - 2);
        memo.put(n, result);
        System.out.println(memo);
        return result;
    }

    public static void main(String[] args) {
        int n = 10; // Example: Calculate the 10th Fibonacci number
        System.out.println("Fibonacci number at position " + n + " is: " + fibonacci(n));
    }
}

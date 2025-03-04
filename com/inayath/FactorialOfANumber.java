package com.inayath;

public class FactorialOfANumber {

    public static void main(String[] args) {

        //using recursive
        System.out.println(factorial(5));


    }

    private static int factorial(int n) {

        //Using recursive

        if (n < 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
//       }

            //Using while loop
//        int result = 1;
//        while (n>1) {
//
//            result = result * n;
//            n--;
//        }
//        return result;

        }
    }
}

//5*(5-1)*(4-1)*(3-1)*(2-1)
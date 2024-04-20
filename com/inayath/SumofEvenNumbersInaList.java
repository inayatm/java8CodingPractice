package com.inayath;

import java.util.Arrays;
import java.util.List;

public class SumofEvenNumbersInaList {
    public static void main(String[] args) {

        List<Integer> numbers= Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        //Way 1
        int sumOfEvenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(n -> n)
                .sum();

        System.out.println("sum Of EvenNumbers: " +sumOfEvenNumbers);

         //Way 2
        int sumOfEvenNumbers1=numbers.stream()
                .filter(n -> n % 2 == 0)
                .reduce(0,Integer::sum)
                .intValue();

        System.out.println("sum Of EvenNumbers using reduce: " +sumOfEvenNumbers1);



    }
}

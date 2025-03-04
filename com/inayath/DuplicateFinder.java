package com.inayath;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DuplicateFinder {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 2, 6, 7, 3, 8, 9, 4);

        findDuplicateUsingStreams(numbers);

        int[] numbersArray = {1, 2, 3, 4, 5, 2, 6, 7, 3, 8, 9, 4};
        findDuplicate(numbersArray);
        int[] numbersArray1 = new int[]{10,10,10,2,3,4,20,20};
        findDuplicateArrays(numbersArray1);

    }

    private static void findDuplicateUsingStreams(List<Integer> numbers) {

        System.out.println( numbers.stream()
                 .collect(Collectors.groupingBy(n->n))
                 .entrySet()
                 .stream()
                 .filter(entry->entry.getValue().size()>1)
                 .map(entry->entry.getKey())
                 .collect(Collectors.toList()));
    }
    private static void findDuplicate(int[] numbers) {

       int[] numbersArray = new int[]{10,10,10,2,3,4,20};
        List l = IntStream.of(numbersArray)
                .boxed()
                .distinct()
                .collect(Collectors.toList());

        System.out.println(l);

    }
    private static void findDuplicateArrays(int[] numbersArray) {


       int[] temp = new int[numbersArray.length];
        for (int i = 0; i < numbersArray.length; i++) {
            int j=i+1;
            while(j<numbersArray.length) {
                if (numbersArray[i] == numbersArray[i+1]) {
                    if(temp[i] ==0) {
                        temp[i] = numbersArray[i];
                    }
                }
                j++;
            }
        }

        for(int i:temp){
            System.out.print(i+" ");
        }

    }
}

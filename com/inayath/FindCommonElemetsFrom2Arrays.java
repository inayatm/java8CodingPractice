package com.inayath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FindCommonElemetsFrom2Arrays {

    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {4, 5, 6, 7};

        int[] commonElements = findCommonElements(array1, array2);

        for(int i:commonElements){
            System.out.println(i);
        }

        int[] commonElements_old = findCommonElements_old(array1, array2);

        for(int i:commonElements){
            System.out.println(i);
        }

    }

    private static int[] findCommonElements(int[] array1,int[] array2){

       return Arrays.stream(array1)
                .distinct()
                .filter(x->Arrays.stream(array2).distinct().anyMatch(y->y==x))
                .toArray();
    }


    private static int[] findCommonElements_old(int[] array1,int[] array2) {
        List<Integer> integerList = new ArrayList<>();
        int i,j;
        i=j=0;
         while(i<array1.length && j<array2.length){
                if (array1[i] == array2[j]) {
                    integerList.add(array1[i]);
                    i++;
                    j++;
                } else if (array1[i] < array2[j]) {
                    i++;
                } else {
                    j++;
                }
            }
        return integerList.stream().mapToInt(n->n).toArray();

    }




}

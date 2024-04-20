package com.inayath;

import java.util.Arrays;

public class ThreeLargestElementsInArray {

    public static void main(String[] args) {
        int array[] = {12, 13, 1, 10, 34, 1, 13};
      //  threeLargestElement_old(array);

     //   threeLargestElement(array);

     //   find3largest(array);

        java8Way(array);

    }

    private static void java8Way(int[] array) {
        Arrays.stream(array)
               .distinct()
               .boxed()
               .sorted((a,b)->Integer.compare(b,a))
               .limit(3)
               .forEach(System.out::println);
    }

    private static void threeLargestElement(int[] array) {
        int first, second, thrid;
        first = second = thrid = Integer.MIN_VALUE;
        int[] values = {first, second, thrid};

        Arrays.stream(array)
                .forEach(num -> {
                    if (num > values[0]) {
                        values[2] = values[1];
                        values[1] = values[0];
                        values[0] = num;
                    } else if (num > values[1]) {
                        values[2] = values[1];
                        values[1] = num;
                    } else if (num > values[2]) {
                        values[2] = num;
                    }
                });
        Arrays.stream(values).forEach(System.out::println);
    }

    private static void threeLargestElement_old(int[] array) {
        int first, second, thrid;
        first = second = thrid = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > first) {
                thrid = second;
                second = first;
                first = array[i];

            } else if (array[i] > second) {
                thrid = second;
                second = array[i];
            } else if (array[i] > thrid) {
                thrid = array[i];
            }
        }

        System.out.println(first);
        System.out.println(second);
        System.out.println(thrid);
    }

   static void find3largest(int[] arr)
    {
       Arrays.sort(arr);
       int n=arr.length;
       int count=0;
       int check=0;
        for (int i = 1; i < n; i++) {
            if(count<3) {
                if(check!=arr[n-i]) {
                    System.out.println(arr[n - i]);
                    check=arr[n-i];
                    count++;
                }
            }
            }



    }


}

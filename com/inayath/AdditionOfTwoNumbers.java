package com.inayath;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AdditionOfTwoNumbers{

    public static void main(String[] args) {

       List<Integer> numbers= Stream.of(10,20).map(n->n+n).collect(Collectors.toList());

        System.out.println(numbers);  // [20,40]

       int doubleIt= Stream.of(10,20).map(n->n+n).reduce(0,(i1, i2) -> i1+i2);

        System.out.println(doubleIt); //  60

        int sum =Stream.of(10,20).reduce(0,(i1,i2)->i1+i2);
        System.out.println(sum); // 30

       int multi = List.of(1,2,3,4,5,6,7,8,9,10).stream().reduce(1,(i1, i2)->i1*i2);
        System.out.println(multi);
        List multiofSeries = List.of(1,2,3,4,5,6,7,8,9,10).stream().map(i->i*i).collect(Collectors.toList());
        System.out.println(multiofSeries);

        List sortedofSeries = List.of(1,2,3,4,5,6,7,8,9,10).stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(sortedofSeries);




    }

}


@FunctionalInterface
interface AddTwoNumbers {

    public abstract int add(int a, int b);
}

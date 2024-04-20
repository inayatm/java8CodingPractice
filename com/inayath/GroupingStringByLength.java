package com.inayath;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class GroupingStringByLength {

    public static void main(String[] args) {
        List<String> counties= Arrays.asList("India","America","Afghanistan","England","Dubai","Dubai");

        //GroupingBy
        Map<Integer, List<String>> stringsByLength  = counties.stream()
                                  .collect(Collectors.groupingBy(String::length));
        System.out.println(stringsByLength);
      //  output: {5=[India, Dubai, Dubai], 7=[America, England], 11=[Afghanistan]}

        Map<String, Long> map = counties.stream()
                .collect(Collectors.groupingBy(name -> name,Collectors.counting()));
        System.out.println(map);

     //   output:{Afghanistan=1, America=1, England=1, Dubai=2, India=1}

        //toMap --count the no of characters in each element of the list

        Map<String, Integer> stringIntegerMap = counties.stream()
                .distinct()
                .collect(Collectors.toMap(name -> name, String::length));

        System.out.println(stringIntegerMap);

       // output: {Afghanistan=11, America=7, England=7, Dubai=5, India=5}

        //average
        OptionalDouble average = counties.stream()
                .mapToInt(String::length)
                .average();
        System.out.println(average.getAsDouble());

       // output: 6.666666666666667

       long count= counties.stream()
                .count();
        System.out.println(count);

       // output: 6

    }

}

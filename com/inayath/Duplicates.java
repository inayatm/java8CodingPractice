package com.inayath;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Duplicates {

    public static void main(String[] args) {

        List<Integer> numbers= Arrays.asList(4, 2, 4, 5, 2, 3, 1);
        numbers.stream()
                .collect(Collectors.groupingBy(n->n))
                .entrySet()
                .stream()
                .filter(entry->entry.getValue().size()>1)
                .forEach(entry->
                        System.out.println(entry.getKey())
                );


    }
}

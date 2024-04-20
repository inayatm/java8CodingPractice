package com.inayath;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DuplicateFinder {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 2, 6, 7, 3, 8, 9, 4);

       System.out.println( numbers.stream()
                .collect(Collectors.groupingBy(n->n))
                .entrySet()
                .stream()
                .filter(entry->entry.getValue().size()>1)
                .map(entry->entry.getKey())
                .collect(Collectors.toList()));
    }
}

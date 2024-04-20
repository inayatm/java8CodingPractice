package com.inayath;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ToUpper {
    public static void main(String[] args) {
        print(
                Arrays.asList("apple", "banana", "orange")
                        .stream()
                        .map(String::toUpperCase)
                        .collect(Collectors.toList()));
    }

    static void print(List<String> strList) {
        System.out.println(strList);
    }
}

package com.inayath;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CompressLongStringToExpand {
    public static void main(String[] args) {

        String str ="AAAAAAAABBBBBBBBBBB11111122222DDDDDDDDDDEEEEEEEF";

        Map<Integer,Character> characterMap =new LinkedHashMap<>();
        Set<String> charset=new HashSet<>();
        Map<Character, Long> collect = str.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
       String compressedString = collect.entrySet().stream().map(s->s.getValue()+""+s.getKey()).collect(Collectors.joining());

        System.out.println(compressedString);


    }
}

package com.inayath;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DistinctList {

    public static void main(String[] args) {
      System.out.println("List of distinct elements -"+ List.of(1,1,2,2,5,3,7,3,9,7)
                .stream()
                .distinct()
                .collect(Collectors.toList())
      );

        System.out.println("count of distinct` elements -"+ List.of(1,1,2,2,5,3,7,3,9,7)
                .stream()
                .distinct()
                .count()
        );

    }
}

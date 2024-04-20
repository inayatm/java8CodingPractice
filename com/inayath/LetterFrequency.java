package com.inayath;

import java.util.HashMap;
import java.util.Map;

public class LetterFrequency {
    public static void main(String[] args) {
        String str = "Hello, World!";
        Map<Character, Integer> frequencyMap = new HashMap<>();

        // Count the frequency of each letter
        for (char c : str.toCharArray()) {
            if (Character.isLetter(c)) {
                c = Character.toLowerCase(c);
                frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
            }
        }

        // Display the frequency of each letter
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
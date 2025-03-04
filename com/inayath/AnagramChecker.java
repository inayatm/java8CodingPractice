package com.inayath;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class AnagramChecker {

    public static boolean areAnagramsUsingArray(String s1,String s2){
       char[] chararray1 = s1.toLowerCase().replaceAll("\\s","").toCharArray();
       char[] chararray2 = s2.toLowerCase().replaceAll("\\s","").toCharArray();
        Arrays.sort(chararray1);
        Arrays.sort(chararray2);

       return Arrays.equals(chararray1,chararray2);
    }

    public static boolean areAnagrams(String str1, String str2) {
        // Remove spaces and convert to lowercase
        str1 = str1.replaceAll("\\s", "").toLowerCase();
        str2 = str2.replaceAll("\\s", "").toLowerCase();

        // Check if lengths are different
        if (str1.length() != str2.length()) {
            return false;
        }

        // Create an array to track character frequencies
        int[] charCount = new int[26]; // Assuming input contains only lowercase alphabets

        // Increment the count for characters in str1 and decrement for characters in str2
        for (int i = 0; i < str1.length(); i++) {
            charCount[str1.charAt(i) - 'a']++;

            charCount[str2.charAt(i) - 'a']--;
        }

        // If the strings are anagrams, all counts in charCount array should be zero
        return Arrays.stream(charCount).allMatch(count -> count == 0);
    }

    public static boolean areAnagramsImprovised(String str1,String str2){

        boolean isAnagram = str1.chars().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString().equals(str2.chars().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString());

        return isAnagram;
    }

    //public static boolean areAnagramsUsingHashmap(String str1,String str2){

      //  Map<Character,Integer> charcount =new HashMap<>();

       // Character[] characters = str1.toLowerCase().chars().map(c->(char)c).sorted().




//    }


    public static void main(String[] args) {
        String str1 = "lis tenTTTTTT";
        String str2 = "silenTTTTTTT";

        boolean result = areAnagrams(str1, str2);
        System.out.println("Are the strings anagrams? " + result);

        System.out.println("Are the strings anagrams?Using StirngBuilder:: "+areAnagramsImprovised(str1,str2));

        System.out.println("Are two Anagrams:Uisng Array:: "+ areAnagramsUsingArray(str1,str2));
    }


}
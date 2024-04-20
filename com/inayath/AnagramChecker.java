package com.inayath;

import java.util.Arrays;

public class AnagramChecker {
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

    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";

        boolean result = areAnagrams(str1, str2);
        System.out.println("Are the strings anagrams? " + result);

        System.out.println(areAnagramsImprovised(str1,str2));
    }

   public static boolean areAnagramsImprovised(String str1,String str2){

       boolean isAnagram = str1.chars().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
               .toString().equals(str2.chars().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString());

       return isAnagram;
   }
}
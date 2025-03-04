package com.inayath;

import java.util.stream.IntStream;

public class PalindromeString {

    public static void main(String[] args) {

        boolean ispal = isPalindrome("racecar");
        System.out.println(ispal);
        boolean ispal8 = isPalindromejava8("madam");
        System.out.println(ispal8);
        System.out.println(ispalindromeWithoutStirng("racecar"));
        System.out.println(ispalindromeWithStirngBuilder("racecar"));

        System.out.println(" ispalindromeRecursive "+ispalindromeRecursive("radar"));
    }

    private static boolean isPalindrome(String str) {
        boolean ispal = false;
        int n = str.length() - 1;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == str.charAt(n - i)) {
                ispal = true;
            } else {
                ispal = false;
            }
        }
        return ispal;

    }


    //jav8
    private static boolean isPalindromejava8(String str) {

        int n = str.length() - 1;
        return IntStream.range(0, str.length()).allMatch(i -> str.charAt(i) == str.charAt(n - i));


    }


    //without using string library

    private static boolean ispalindromeWithoutStirng(String str){

            boolean ispal =true;
            char[] chararray =str.toCharArray();

            int left=0;
            int right=chararray.length-1;
            while(left<=right){
                if(chararray[left] != chararray[right]){
                    ispal = false;
                }
                left++;
                right--;
            }

        return ispal;
    }
    private static boolean ispalindromeWithStirngBuilder(String str) {

        StringBuilder str1 = new StringBuilder(str);
        String reverse = str1.reverse().toString();
        return str.equals(reverse);

    }
    private static boolean ispalindromeRecursive(String str) {
        if (str.length() == 1) {
            return false;
        } else if (str.charAt(0) != str.charAt(str.length() - 1)) {
            return false;
        } else {
            return isPalindrome(str.substring(1, str.length() - 1));
        }

    }



}





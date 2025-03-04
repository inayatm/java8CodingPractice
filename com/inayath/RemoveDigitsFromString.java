package com.inayath;

public class RemoveDigitsFromString {
    public static void main(String[] args) {
        String str = "Hello@World! 123 #Java$";
        String clearString ="";
        for (int i = 0; i < str.length()-1; i++) {
            char ch = str.charAt(i);
            if(!(ch >= '0'&& ch <= '9')){
                clearString =clearString+ch;
            }
        }
        System.out.println(clearString);
    }

}

package com.inayath;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringLogical {
    public static void main(String[] args) {
        String str = "silent";
        String str1 = "listen";
        //System.out.println(isAnagram(str, str1));
        System.out.println(isAnagramImprovise(str,str1));
        System.out.println(totalWordCount("test tests"));
        System.out.println(wordCount("test test1 test test1"));
        System.out.println(stringCompression("abaaaabccccdddee"));
        System.out.println(reverseTheWordsInaSentance("Hello World!"));
        System.out.println(transformString("Hello Wold abc"));
    }

    private static String transformString(String str) {
//        AtomicReference<String> result= new AtomicReference<>("");
//        Arrays.stream(str.split(" "))
//                .forEach(word->{
//                    result.set(word+" "+result);
//                });
//        return result.toString();
       return  Arrays.stream(str.split(" "))
                .reduce((word1,word2)->word2+" "+word1)
               .orElse("");



    }

    private static String reverseTheWordsInaSentance(String s) {
        return Arrays.stream(s.split(" "))
                .map(word->new StringBuilder(word).reverse())
                .collect(Collectors.joining());

    }

    private static String stringCompression(String str) {
             return       str.chars().mapToObj(c->String.valueOf((char)c))
                    .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                            .entrySet()
                            .stream()
                            .map(entry->entry.getKey()+" "+entry.getValue())
                            .collect(Collectors.joining());
    }

    //O(n^2)
    public static boolean isAnagram(String str, String str1) {
        boolean isAngram = true;
        if (str.length() != str1.length())
            isAngram = false;
        for (int i = 0; i < str.length(); i++) {
            if (!str1.contains("" + str.charAt(i))) {
                isAngram = false;
                return isAngram;
            }
        }
        return isAngram;
    }

    //O(n)
    public  static boolean isAnagramImprovise(String str, String str1) {

        int count[]=new int[26];
        if (str.length() != str1.length())
            return false;
        for (int i = 0; i < str.length(); i++) {
             count[str.charAt(i)-'a']++;
            // count[str1.charAt(i)-'a']--;
            }
        for (int i = 0; i < count.length; i++) {
            if(count[i]>1)
                return false;
        }
    return true;
    }


    public static long totalWordCount(String sentence){
        sentence.replaceAll("\\s"," ");
       return Arrays.stream(sentence.split(" "))
                .count();

    }

    public static String wordCount(String sentence){
        sentence.replaceAll("\\s"," ");
      return   Arrays.stream(sentence.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .map(entry-> entry.getValue()+entry.getKey())
                .collect(Collectors.joining());


    }




}
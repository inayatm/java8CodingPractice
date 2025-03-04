package com.inayath;

public class RemoveSpecialCharInAString {
    public static void main(String[] args) {
        String str = "Hello@World! 123 #Java$";
        removeSpecialChar(str);
        //UsingRegularExp(str);

        int A ='A';
        int Z ='Z';
        int a ='a';
        int z ='z';
        int zero ='0';
        int exp='!';
        int at='@';
        int yash='#';

        System.out.println("A: " +A);
        System.out.println("Z: " +Z);
        System.out.println("a: " +a);
        System.out.println("z: " +z);
        System.out.println("exp!!: " +exp);
        System.out.println("@: " +at);
        System.out.println("##: " +yash);
    }

    private static void removeSpecialChar(String str) {
        String clear ="";
        for (int i = 0; i < str.length()-1; i++) {

            char ch = str.charAt(i);
            if((ch >= 'A' && ch <='Z') ||
                    ((ch >= 'a' && ch <='z')) ||
                    ((ch >= '0' && ch <='9')) ||
                    (ch == ' ')){
                int temp=ch;
                System.out.println("ch: "+ch+"--"+temp);
                clear = clear+ ch;
            }

        }
        System.out.println("Special Characters removed: "+clear);
    }


    private static void UsingRegularExp(String str){

        String clearString =str.replaceAll("[^a-zA-z0-9]","");
        System.out.println(clearString);
    }
}

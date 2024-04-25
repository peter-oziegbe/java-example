package org.example.algorithm;

public class Palindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("madam"));
        System.out.println(isPalindrome("civic"));
    }

    public static boolean isPalindrome(String text){
        char[] char1 = new char[text.length()];
        char[] char2 = new char[text.length()];
        for(int x = 0; x < char1.length; ++x){
            char1[x] = text.charAt(x);
        }
        for(int y = 0; y < char2.length; ++y){
            char2[y] = char1[text.length() - 1 - y];
        }
       return new String(char2).equals(text);
    }
}

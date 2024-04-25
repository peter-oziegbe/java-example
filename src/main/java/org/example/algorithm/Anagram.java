package org.example.algorithm;

import java.util.HashMap;
import java.util.Map;

public class Anagram {
    public static void main(String[] args) {

        /*
        * anagram = nag a ram

        * */
        System.out.println(isAnagram("anagram", "nag a ram"));
        System.out.println(isAnagram("study", "dusty"));
    }

    public static boolean isAnagram(String arg1, String arg2){
        arg1 = arg1.replaceAll("\\s+", "");
        arg2 = arg2.replaceAll("\\s+", "");
        if(arg1.length() != arg2.length()){
            return false;
        }
        int length = arg1.length();
        Map<Character, Integer> mapForArg1 = new HashMap<>();
        Map<Character, Integer> mapForArg2 = new HashMap<>();
        for(int x  = 0; x < length; ++x){
            mapForArg1.put(arg1.charAt(x), mapForArg1.get(arg1.charAt(x)) == null ? 1: arg1.charAt(x) + 1);
            mapForArg2.put(arg2.charAt(x), mapForArg2.get(arg2.charAt(x)) == null ? 1: arg2.charAt(x) + 1);
        }
        return mapForArg1.equals(mapForArg2);
    }
}

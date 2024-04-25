package org.example;

import java.util.*;

class Solution {
    public String reverseWords(String s) {
        String[] tokens = s.split("\\s+");
        List<String> newArray = Arrays.asList(tokens);


        Collections.reverse(newArray);
        String result = "";

        StringBuilder f;

        for(String a : newArray){
            result = result + " "+ a;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseWords(" I          love you     "));
    }
}
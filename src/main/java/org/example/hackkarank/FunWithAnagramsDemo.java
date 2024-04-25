package org.example.hackkarank;

import java.util.*;

public class FunWithAnagramsDemo {
    public static List<String> funWithAnagrams(String[] test) {
        List<String> result = new ArrayList<>();
        Set<String> uniqueStrings = new HashSet<>();

        for (String str : test) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);

            if (!uniqueStrings.contains(sortedStr)) {
                result.add(str);
                uniqueStrings.add(sortedStr);
            }
        }

        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
        String[] test = {"code", "doce", "framer", "frame"};
        List<String> result = funWithAnagrams(test);
        for (String str : result) {
            System.out.println(str);
        }
    }
}

/*
*Two strings are anagrams if thet are permutations of each other. In other words, both string have the same size and same character. For example, “aagmnrs” is an anagram of “anagrams”. Given an array of string, remove each string that is an anagram of an earlier string, then retrun the remaining array in sorted alphabetical order.

Example
str = [‘code’, ‘doce’, ‘framer’, ‘frame’]

“code” and “doce” are anagram. Remove “doce” from the array and keep the first occurrance “code” in the array.
“code” and “ecod” are anagrams. Remove “ecod” from the array and keep the first occurrence “code” in the array.
“code” and “framer” are not anagrams. Keep both strings in the array.
“framer” and frame are not anagrams due to the extra ‘r’ in ‘framer’. keep both string in the array.
Order the remaining string in ascending alphanetical order: [“code”, “frame”, “framer"]


Function Description
Complete the function funWithAnagrams using Java and use very efficient algorithm.

functionWithAnagram has the following parameters:
string test[n]: an array of strings
Returns:
string[m]: an array of the remaining strings in ascending order.
* */

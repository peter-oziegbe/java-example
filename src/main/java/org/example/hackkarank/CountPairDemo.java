package org.example.hackkarank;

import java.util.*;

public class CountPairDemo{
    public static int countPairs(int[] numbers, int k) {
        Set<Integer> numSet = new HashSet<>();
        Set<Integer> pairs = new HashSet<>();

        for (int num : numbers) {
            if (numSet.contains(num - k)) {
                pairs.add(num - k);
            }
            if (numSet.contains(num + k)) {
                pairs.add(num);
            }
            numSet.add(num);
        }

        return pairs.size();
    }

    public static void main(String[] args) {
        Class clazz = CountPairDemo.class;
        Object object;

        // Test case
        int[] numbers = {1, 2, 2, 3, 3, 1};
        int k = 1;
        System.out.println("Number of valid pairs: " + countPairs(numbers, k)); // Output: 2
    }
}

/**
 * Given an integer k and a list of integers, count the number of distinct valid pairs of integers (a, b) in the list for which a + k = b. Two pairs of integers (a, b) and (c, d) are considered distinct if at least one element of (a, b) does not also belong to (c, d).
 *
 * Example
 * n = 4
 * numbers = [1, 1, 1, 2]
 * k = 1
 *
 * This array has two different valid pairs: (1, 1) and (1, 2). For k = 1, there is only 1 valid pair which satisfies a + k = b: the pair (a, b) = (1, 2).
 *
 * Function Description
 * Complete the function countPairs using Java and the most efficient algorithm.
 *
 * countPairs has the following parameters(s):
 * int number[n]: array of integers
 * int k: target difference
 *
 * Returns
 * Int: number of valid (a, b) pairs in the numbers array that have a difference of k.
 *
 * Write a unit test that given
 *
 * Number as a list of integers 1 2 2 3 3 1 and k as 1
 *
 * Return 2 as the expected result
 * */

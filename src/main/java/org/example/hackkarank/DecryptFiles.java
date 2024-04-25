package org.example.hackkarank;

import java.util.*;

import java.util.*;

public class DecryptFiles {

    public static int getMaxValueSum(int[] encrypted_files, int[] binary, int k) {
        int n = encrypted_files.length;
        int maxValueSum = 0;
        /* //*/

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            if (binary[i] == 1) {
                maxHeap.offer(encrypted_files[i]);
            }
        }

        while (!maxHeap.isEmpty()) {
            int operations = Math.min(k, maxHeap.size());
            int sum = 0;
            for (int i = 0; i < operations; i++) {
                sum += maxHeap.poll();
            }
            maxValueSum += sum;
        }

        return maxValueSum;
    }

    // Unit test
    public static void main(String[] args) {
        int[] encrypted_files = {1, 3, 5, 2, 5, 4};
        int[] binary = {1, 1, 0, 1, 0, 0};
        int k = 3;

        int result = getMaxValueSum(encrypted_files, binary, k);
        int expected = 16;

        // Print actual and expected results
        System.out.println("Actual Result:   " + result);
        System.out.println("Expected Result: " + expected);

        // Check if the actual result matches the expected result
        if (result == expected) {
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed!");
        }
    }
}



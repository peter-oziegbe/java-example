package org.example.hackkarank;


import java.util.Arrays;

import java.util.List;

public class Solution {

    public static int getMaxValueSum(List<Integer> encryptedFiles, List<Integer> binary, int k) {
        int n = encryptedFiles.size();
        int maxValueSum = 0;
        int currentSum = 0;

        // Calculate the initial sum of decrypted files
        for (int i = 0; i < n; i++) {
            if (binary.get(i) == 1) {
                currentSum += encryptedFiles.get(i);
            }
        }
        maxValueSum = currentSum;

        // Use sliding window approach to find the maximum value sum
        for (int i = 0; i < n; i++) {
            if (binary.get(i) == 0) {
                // If the file at index i is encrypted, add its value to the current sum
                currentSum += encryptedFiles.get(i);
            } else {
                // If the file at index i is decrypted, subtract its value from the current sum
                currentSum -= encryptedFiles.get(i);
            }
            // Slide the window by adding the value of the next file and subtracting the value of the file k positions earlier
            if (i >= k) {
                if (binary.get(i - k) == 0) {
                    currentSum -= encryptedFiles.get(i - k);
                } else {
                    currentSum += encryptedFiles.get(i - k);
                }
            }
            // Update the maximum value sum found so far
            maxValueSum = Math.max(maxValueSum, currentSum);
        }

        return maxValueSum;
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        List<Integer> encryptedFiles = List.of(7, 4, 3, 5);
        List<Integer> binary = List.of(1, 0, 0, 0);
        int result = getMaxValueSum(encryptedFiles, binary, k);
        System.out.println("Maximum possible value sum of decrypted files: " + result); // Output: 15
    }
}



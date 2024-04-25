package org.example.hackkarank;

public class FountainActivation {
    public static int minFountains(int[] locations) {
        int n = locations.length;
        int[] dp = new int[n]; // dp array to store the farthest point each fountain can reach

        for (int i = 0; i < n; i++) {
            int left = Math.max(i - locations[i], 0); // left boundary for coverage
            int right = Math.min(i + locations[i], n - 1); // right boundary for coverage
            dp[left] = Math.max(dp[left], right); // update dp array
        }

        int fountains = 1;
        int currentEnd = dp[0];
        int nextEnd = 0;

        for (int i = 0; i < n; i++) {
            nextEnd = Math.max(nextEnd, dp[i]);
            if (i == currentEnd) { // if current fountain's coverage ends
                fountains++; // activate a new fountain
                currentEnd = nextEnd; // update currentEnd to the farthest point the newly activated fountain can reach
            }
        }

        return fountains;
    }

    public static void main(String[] args) {
        int[] locations = {2, 0, 1, 0, 1};
        System.out.println("Minimum number of fountains needed: " + minFountains(locations));
    }
}

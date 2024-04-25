package org.example.hackkarank;

import java.util.HashMap;
import java.util.Map;

import java.util.*;

public class SessionAuthentication {

    public static List<Integer> getUnexpiredTokens(int time_to_live, List<String> queries) {
        Map<String, Integer> tokenExpirationMap = new HashMap<>(); // Store token expiration time
        TreeMap<Integer, Set<String>> expirationTimeMap = new TreeMap<>(); // Store tokens sorted by expiration time
        List<Integer> unexpiredCountList = new ArrayList<>(); // Store counts of unexpired tokens

        for (String query : queries) {
            String[] queryParts = query.split(" ");
            String action = queryParts[0].toLowerCase(); // Convert action to lowercase to handle case sensitivity

            if (action.equals("count")) {
                int current_time = Integer.parseInt(queryParts[1]);
                while (!expirationTimeMap.isEmpty() && expirationTimeMap.firstKey() <= current_time) {
                    Set<String> expiredTokens = expirationTimeMap.pollFirstEntry().getValue();
                    for (String token : expiredTokens) {
                        tokenExpirationMap.remove(token);
                    }
                }
                unexpiredCountList.add(tokenExpirationMap.size());
            } else {
                String token_id = queryParts[1];
                int current_time = Integer.parseInt(queryParts[2]);

                if (action.equals("generate")) {
                    int tokenExpiration = current_time + time_to_live;
                    tokenExpirationMap.put(token_id, tokenExpiration);
                    expirationTimeMap.computeIfAbsent(tokenExpiration, k -> new HashSet<>()).add(token_id);
                } else if (action.equals("renew")) {
                    if (tokenExpirationMap.containsKey(token_id) && tokenExpirationMap.get(token_id) > current_time) {
                        int tokenExpiration = current_time + time_to_live;
                        expirationTimeMap.get(tokenExpirationMap.get(token_id)).remove(token_id);
                        tokenExpirationMap.put(token_id, tokenExpiration);
                        expirationTimeMap.computeIfAbsent(tokenExpiration, k -> new HashSet<>()).add(token_id);
                    }
                }
            }
        }

        return unexpiredCountList;
    }

    // Unit test
    public static void main(String[] args) {
        List<String> queries = List.of("35", "6", "generate token1 3", "count 4", "generate token2 6", "count 7", "generate token3 11", "count 41");
        int time_to_live = Integer.parseInt(queries.get(0));
        queries = queries.subList(2, queries.size());

        long startTime = System.currentTimeMillis(); // Start time

        List<Integer> result = getUnexpiredTokens(time_to_live, queries);
        List<Integer> expected = List.of(1, 2, 1);

        long endTime = System.currentTimeMillis(); // End time
        long executionTime = endTime - startTime; // Execution time in milliseconds

        // Print actual and expected results
        System.out.println("Actual Result:   " + result);
        System.out.println("Expected Result: " + expected);
        System.out.println("Execution Time: " + executionTime + " ms");

        // Check if the actual result matches the expected result
        if (result.equals(expected)) {
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed!");
        }
    }
}










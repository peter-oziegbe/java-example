package org.example.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindPair {

    public static void main(String[] args) {

        System.out.println(findSumPair(Arrays.asList(3, 2, 5, 1, 3, 4), 5));
    }
    public static List<Integer> findSumPair(List<Integer> numbers, int k) {
        List<Integer> result = new ArrayList<>();
        for (int x = 0; x < numbers.size(); ++x){
            for (int y = x + 1; y < numbers.size(); ++y){
                int sum = numbers.get(x) + numbers.get(y);
                if(sum == k){
                    result.add(sum);
                }
            }
        }
        return result;
    }
}

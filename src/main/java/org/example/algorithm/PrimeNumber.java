package org.example.algorithm;

public class PrimeNumber {

    public static void main(String[] args) {
        System.out.println(isPrimeNumber(2));
    }

    public static boolean isPrimeNumber(int number){
        if(number <= 1){
            return false;
        }
        for(int x = 2; x < number; ++x){
            if(number % x == 0){
                return false;
            }
        }
        return true;
    }
}

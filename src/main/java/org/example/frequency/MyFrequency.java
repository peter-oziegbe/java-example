package org.example.frequency;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MyFrequency {

    public static void main(String[] args) {

        /*
        int[] array = {6, 3, 4, 2, 1, 6, 7, 3, 6};

        HashMap<String, Integer> frequencies = new HashMap<>();


        for(int a: array){
            frequencies.put(a+"",  frequencies.get(a+"") != null ? frequencies.get(a+"") + 1 : 1);
        }

        System.out.println(frequencies);


        System.out.println("isAnagram: "+  isAnagram("bad credit", "debit card"));
        System.out.println("isPalindrome: " +  isPalindrome("kayak"));

*/

        //int[] a = {-1, -2, 3, 4, 9, 2};

        //closestToZero(a);


        HashMap m = new HashMap();
        String o1 = new String();

        String  o2 = o1;

        m.put(o1, 1);
        m.put(o2, 2);

        System.out.println(m.get(o1));


    }


    class Solution {

        public static String[] filterWords(String[] words, String letters) {
            // Write your code here
            // To debug: System.err.println("Debug messages...");

            List<String> storage = new ArrayList<>();

            for (String s : words) {
                if (s.contains(letters)) {
                    storage.add(s);
                }
            }

            String[] result = storage.toArray(new String[0]);
            return result;
        }

        /* Ignore and do not change the code below */
        public static void mains(String args[]) {
            /*
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            if (in.hasNextLine()) {
                in.nextLine();
            }
            String[] words = new String[n];
            for (int i = 0; i < n; i++) {
                words[i] = in.nextLine();
            }
            String letters = in.nextLine();
            PrintStream outStream = System.out;
            System.setOut(System.err);
            String[] remaining = filterWords(words, letters);
            System.setOut(outStream);
            for (int i = 0; i < remaining.length; i++) {
                System.out.println(remaining[i]);
            }
        }
        /* Ignore and do not change the code above */
        }

        public static boolean isAnagram(String original, String anagram) {

            original = original.replaceAll("\\s+", "");
            anagram = anagram.replaceAll("\\s+", "");

            if (original.length() != anagram.length()) {
                return false;
            }

            int length = original.length();
            HashMap<Character, Integer> originalFrequency = new HashMap<>();
            HashMap<Character, Integer> anagramFrequency = new HashMap<>();

            for (int x = 0; x < length; ++x) {

                var value = originalFrequency.get(original.charAt(x));
                originalFrequency.put(original.charAt(x), value != null ? ++value : 1);

                var value2 = anagramFrequency.get(anagram.charAt(x));
                anagramFrequency.put(anagram.charAt(x), value2 != null ? ++value2 : 1);
            }

            return originalFrequency.equals(anagramFrequency);
        }


        public static boolean isPalindrome(String str) {
            int strLength = str.length();

            char[] originalChars = new char[str.length()];


            char[] reverseChars = new char[str.length()];

            for (int x = 0; x < strLength; ++x) {
                originalChars[x] = str.charAt(x);
            }

            for (int i = 0; i < strLength; ++i) {
                reverseChars[i] = originalChars[strLength - 1 - i];
            }

            String s = new String(reverseChars);

            return s.equals(str);
        }


        public static boolean isPrimeNumber(int inputNumber) {
            if (inputNumber <= 1)
                return false;

            // Check from 2 to n-1
            for (int i = 2; i < inputNumber; i++) {
                if (inputNumber % i == 0) {
                    return false;
                }
            }
            return true;
        }

        public boolean isPrime(int number) {
            BigInteger bigInt = BigInteger.valueOf(number);
            return bigInt.isProbablePrime(100);
        }


        public static void closestToZero(int[] tx) {

            var value = IntStream.of(tx)
                    .filter(i -> i > 0)
                    .sorted()
                    .limit(1)
                    .asLongStream();

            System.out.println(value);
        /*
        final List<Integer> list = Arrays.stream(tx)
                .mapToObj(Integer::valueOf)
                .collect(Collectors.toList());

         */
        }

        public static List<Integer> findSumPair(List<Integer> numbers, int k) {
            List<Integer> result = new ArrayList<>();
            for (int x = 0; x < numbers.size(); ++x) {
                for (int y = (x + 1); y < numbers.size() - 1; ++y) {
                    System.out.println("X" + x + ", Y" + y);
                }
            }
            return result;
        }


        public static String fizzBuzz(int number, Map<Integer, String> map) {

            String result = "";

            TreeSet treeSet = new TreeSet(map.entrySet());
            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                Integer k = entry.getKey();
                String v = entry.getValue();
                if (number % k == 0) {
                    result = result = v;
                }
            }

            return Integer.toString(number);
        }
    }
}

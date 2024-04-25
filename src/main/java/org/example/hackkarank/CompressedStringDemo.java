package org.example.hackkarank;

public class CompressedStringDemo {

    public static String compressedString(String message) {
        if (message == null || message.isEmpty()) {
            return "";
        }

        StringBuilder compressed = new StringBuilder();
        int count = 1;
        char currentChar = message.charAt(0);

        for (int i = 1; i < message.length(); i++) {
            char nextChar = message.charAt(i);
            if (nextChar == currentChar) {
                count++;
            } else {
                compressed.append(currentChar);
                if (count > 1) {
                    compressed.append(count);
                }
                count = 1;
                currentChar = nextChar;
            }
        }

        // Append the last character and its count
        compressed.append(currentChar);
        if (count > 1) {
            compressed.append(count);
        }

        return compressed.toString();
    }

    public static void main(String[] args) {
        String message = "abaasass";
        System.out.println(compressedString(message)); // Output: aba2sas2
    }
}


    /*
    * Different compression technique are used to reduce the size of the message sent over the web. An algorrithm is designed to compress a given string be describing the total number consecutive occurrences of each character next to it. For example, cinsider the string “abaasass”. Group the consecutive occurance if each character:

‘a’ occur one time.
‘b’ occur one time.
‘a’ occur two times consecutively.
’s’ occur one time.
‘a’ occur one time.
’s’ occur two times consecutively.

if a character only occur once, it is added to the compressed string. if it occurs consecutive times, the character is added to the string followed by an integer representing the number if consecutive occurences. Thus the compressed form of the string is “aba2sas2”.

Function Description

Complete the function compressedString in Java using the most efficient algorithm. The function must retrun the compressed form of message.

compressedString has the following parameters(s):
string message: a string

Returns:
string the compressed message
    * */

package org.example.exeception;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DemoException {

    public static void main(String[] args)  {

        AutoCloseable autoCloseable;
        java.io.Closeable closeable;
        var info = readFirstLineFromFile("/Users/peteroziegbe/Desktop/mapper.java");

        System.out.println(info);
    }

    public static String readFirstLineFromFile(String path) {
        try (FileReader fr = new FileReader(path);
             BufferedReader br = new BufferedReader(fr)) {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}

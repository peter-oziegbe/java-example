package org.example.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class DemoGeneric {

    public static void main(String[] args) {

        // Generic Class
        GenericPrinter integerPrinter = new GenericPrinter(5);
        integerPrinter.print();

        GenericPrinter doublePrinter = new GenericPrinter(10.3);
        doublePrinter.print();

        GenericPrinter<Double> stringPrinter = new GenericPrinter("Apps");
        stringPrinter.print();

        // Generic Method
        var genericMethod = new GenericMethod();
        genericMethod.print(100);
        //genericMethod.print("Hello word");
        genericMethod.print(4.5);
        genericMethod.add(4 , 3);

        // Generic Raw Type
        ArrayList myArray = new ArrayList();
        myArray.add("5");
        myArray.add(4);
        myArray.add(new GenericMethod());

        myArray.forEach(t -> {
            System.out.println(t);
        });

        // Generic wild card (?)
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(900);
        genericMethod.printList(integers);
    }
}

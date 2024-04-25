package org.example.generic;

import java.util.Optional;

public class StringPrinter {

    private String thingToPrint;

    public StringPrinter(String stringValue){
        this.thingToPrint = stringValue;
    }

    public void print(){
        System.out.println("The value is "+ thingToPrint);
    }
}

package org.example.generic;

public class IntegerPrinter{

    private Integer thingToPrint;

    public IntegerPrinter(Integer thingToPrint){
        this.thingToPrint = thingToPrint;
    }

    public void print(){
        System.out.println("The value is "+ thingToPrint);
    }
}

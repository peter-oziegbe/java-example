package org.example.generic;

public class GenericPrinter<T> {

    private T thingToPrint;

    public GenericPrinter(T thingToPrint){
        this.thingToPrint = thingToPrint;
    }

    public void print(){
        System.out.println("The value is "+ thingToPrint);
    }
}

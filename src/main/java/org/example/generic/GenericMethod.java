package org.example.generic;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class GenericMethod {

    public <T extends Number & Serializable> void print(T tValue){
        System.out.println("Generic method printed " + tValue);
    }

    public <T extends Number & Serializable, V extends Number> void add(T t, V v){
        System.out.println("The sum of the two numbers is  "+ (t.intValue() + v.intValue()) );
    }

    public void printList(List<?> objects) {
        objects.forEach(object -> {
            System.out.println(objects);
        });
    }
}

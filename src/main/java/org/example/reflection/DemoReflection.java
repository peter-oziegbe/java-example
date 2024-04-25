package org.example.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DemoReflection {

    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {

        Car car = new Car(2, "Toyota", "RED");

        Class<? extends Car> aClass = car.getClass();

        // Printing the fields of car
        System.out.println("Printing the fields of car");
        for (Field field : aClass.getDeclaredFields()) {
            System.out.println(field.getName());
        }

        // Printing the methods of car
        System.out.println("Printing the methods of car");
        for (Method method : aClass.getDeclaredMethods()) {
            System.out.println(method.getName());
        }

        // Changing a private field;
        Field engine = aClass.getDeclaredField("engine");
        engine.setAccessible(true);
        engine.set(car, 10);

        System.out.println("Car engine is now: "+ car.getEngine());

        // Print package
        System.out.println("Package " + aClass.getPackage().getName());
        Package aPackage = aClass.getPackage();


        // Involving a method
        Method color = aClass.getDeclaredMethod("getColor");
        System.out.println(color.invoke(car));

        ExpressAnnotation annotation = aClass.getDeclaredField("currentSpeed").getAnnotation(ExpressAnnotation.class);
        System.out.println("ExpressAnnotation "+annotation.value());

    }
}

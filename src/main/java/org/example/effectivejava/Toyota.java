package org.example.effectivejava;

public class Toyota extends Car{

    public Toyota(String color, int currentGearSpeed) {
        super(color, currentGearSpeed);
    }

    @Override
    public void setCurrentGearSpeed(int currentGearSpeed) {
        System.out.println("I've broken encapsulation...");
        System.out.println("getCurrentGearSpeed "+ this.getCurrentGearSpeed());
        System.out.println("Color "+ this.getColor());
    }


    public static void main(String[] args) {
        Toyota toyota = new Toyota("Red", -1);
    }
}

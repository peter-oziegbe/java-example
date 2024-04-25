package org.example.reflection;

public class Car {
    private int cadence;
    private String maker;
    private String color;
    private int engine = 8;

    @ExpressAnnotation(5)
    private int currentSpeed;

    public Car(int cadence, String maker, String color){
        this.cadence = cadence;
        this.maker = maker;
        this.color = color;
        this.currentSpeed = cadence * engine;
    }

    public int getCadence() {
        return cadence;
    }

    public String getColor() {
        return color;
    }

    public String getMaker() {
        return maker;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public int getEngine() {
        return engine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "cadence=" + cadence +
                ", maker='" + maker + '\'' +
                ", color='" + color + '\'' +
                ", engine=" + engine +
                ", currentSpeed=" + currentSpeed +
                '}';
    }
}

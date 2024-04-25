package org.example.effectivejava;

public abstract class Car {
    private String color;
    private int currentGearSpeed;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCurrentGearSpeed() {
        return currentGearSpeed;
    }

    public Car(String color, int currentGearSpeed){
        setCurrentGearSpeed(currentGearSpeed);
        this.color = color;
    }
    public void setCurrentGearSpeed(int currentGearSpeed) {
        if (currentGearSpeed < 1){
            this.currentGearSpeed = 1;
        }else {
            this.currentGearSpeed = currentGearSpeed;
        }
        System.out.println("Current Gear Speed: "+this.currentGearSpeed);
    }
}

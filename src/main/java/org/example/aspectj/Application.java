package org.example.aspectj;

public class Application {
    public static void main(String[] args) {

        AspectJProcessor.bootstrap(Application.class);

        Calculator calculator = new Calculator();
        calculator.execute();
    }
}

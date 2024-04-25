package org.example.aspectj;

@AspectJ
public class Logger {

    @Advice
    @Before
    public void log(){
        System.out.println("Transaction completed");
    }
}

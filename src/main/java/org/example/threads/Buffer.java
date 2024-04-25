package org.example.threads;

public interface Buffer {

    /*
     *  Producer
     * */
    void write(int value) throws InterruptedException;

    /*
     *  Consumer
     * */
    void read() throws InterruptedException;
}

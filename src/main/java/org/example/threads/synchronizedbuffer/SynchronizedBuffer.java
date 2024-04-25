package org.example.threads.synchronizedbuffer;

import org.example.threads.Buffer;

public class SynchronizedBuffer implements Buffer {
    private int buffer = -1; // it is empty at default

    /*
     *  Producer
     * */
    public synchronized void write(int value) throws InterruptedException {
        // wait if it is not empty
        while(buffer != -1){
            System.out.println( "Producer tries to write." );
            System.out.println( "Buffer full. Producer waits." );
            wait();
        }
        this.buffer = value;
        System.out.println("Producer Write "+ buffer + " to buffer");
        notifyAll();
    }

    /*
    *  Consumer
    * */
    public synchronized void read() throws InterruptedException {
        // wait if it is empty
        while(buffer == -1){
            System.out.println( "Consumer tries to read." );
            System.out.println( "Buffer empty. Consumer waits." );
            wait();
        }
        System.out.println("Consumer Read "+ buffer + " to buffer");
        this.buffer = -1;
        notifyAll();
    }
}

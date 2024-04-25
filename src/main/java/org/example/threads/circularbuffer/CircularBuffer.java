package org.example.threads.circularbuffer;

import org.example.threads.Buffer;

public class CircularBuffer implements Buffer {

    private final int[] buffer = {-1, -1, -1};

    private int writeIndex;

    private int readIndex;

    private int occupiedCells;

    @Override
    public synchronized void write(int value) throws InterruptedException {
        while (occupiedCells == buffer.length){
            System.out.println( "Producer tries to write." );
            System.out.println( "Buffer full. Producer waits." );
            wait();
        }
        buffer[writeIndex] = value;
        writeIndex = ( writeIndex + 1 ) % buffer.length;
        System.out.println("Producer Write "+ value + " to buffer");
        ++occupiedCells;
        notifyAll();
        new Thread().join();
    }

    @Override
    public synchronized void read() throws InterruptedException {
        while (occupiedCells == 0){
            System.out.println( "Consumer tries to read." );
            System.out.println( "Buffer empty. Consumer waits." );
            wait();
        }

        int value = buffer[readIndex];
        readIndex = ( readIndex + 1 ) % buffer.length;
        System.out.println("Consumer Read "+ value + " to buffer");
        --occupiedCells;
        notifyAll();
    }
}

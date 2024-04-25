package org.example.threads.blocking;

import org.example.threads.Buffer;

import java.util.concurrent.ArrayBlockingQueue;

public class BlockingBuffer implements Buffer {

    private ArrayBlockingQueue<Integer> buffer = new ArrayBlockingQueue<>(1);

    @Override
    public void write(int value) throws InterruptedException {
        buffer.put(value);
        System.out.printf("Write %s %n", value);
    }

    @Override
    public void read() throws InterruptedException {
        int value = buffer.take();
        System.out.println("Consumer Read "+ value + " to buffer");
    }
}

package org.example.threads.blocking;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class DemoBlockingBuffer {
    public static void main(String[] args) {

        var buffer = new BlockingBuffer();

        Runnable producer = ()->{
            IntStream.range(0, 10).forEach(x -> {
                try {
                    buffer.write(x);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        };

        Runnable consumer = ()->{
            IntStream.range(0, 10).forEach(x -> {
                try {
                    buffer.read();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        };

        ExecutorService executor = Executors.newFixedThreadPool(10);
        executor.execute(producer);
        executor.execute(consumer);
    }
}

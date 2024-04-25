package org.example.threads.synchronizedbuffer;

import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class DemoSynchronizedBuffer {

    public static void main(String[] args) {

        var buffer = new SynchronizedBuffer();

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

        var executor = Executors.newCachedThreadPool();
        executor.execute(producer);
        executor.execute(consumer);

    }
}

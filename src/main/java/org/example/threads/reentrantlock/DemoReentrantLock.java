package org.example.threads.reentrantlock;

import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class DemoReentrantLock {

    public static void main(String[] args) {

        var sharedBuffer = new SynchronizedBuffer();

        Runnable producer = ()->{
            IntStream.range(0, 10).forEach(x -> {
                try {
                    sharedBuffer.write(x);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        };

        Runnable consumer = ()->{
            IntStream.range(0, 10).forEach(x -> {
                try {
                    sharedBuffer.read();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        };

        var executorService = Executors.newCachedThreadPool();
        executorService.execute(producer);
        executorService.execute(consumer);
        executorService.isShutdown();
    }
}

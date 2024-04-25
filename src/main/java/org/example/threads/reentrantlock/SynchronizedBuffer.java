package org.example.threads.reentrantlock;

import org.example.threads.Buffer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedBuffer implements Buffer {

    private int buffer = -1;
    private boolean isOccupied = false;
    private Lock accessLock = new ReentrantLock(true);
    private Condition canRead = accessLock.newCondition();
    private Condition canWrite = accessLock.newCondition();

    @Override
    public void write(int value) throws InterruptedException {
        accessLock.lock(); // acquire a lock
        try {
            while (isOccupied){
                System.out.println( "Producer tries to write." );
                System.out.println( "Buffer full. Producer waits." );
                canWrite.await(); // wait on the canWriteCondition
            }
            this.buffer = value;
            isOccupied = true;
            System.out.println("Write "+ this.buffer + " to buffer");
            canRead.signalAll();
        }finally {
            accessLock.unlock();
        }
    }

    @Override
    public void read() throws InterruptedException {
        accessLock.lock(); // acquire a lock
        try {
            while (!isOccupied){
                System.out.println( "Consumer tries to read." );
                System.out.println( "Buffer empty. Consumer waits." );
                canRead.await(); // wait on the canReadCondition
            }
            isOccupied = false;
            System.out.println("Consumer Read "+ buffer + " to buffer");
            canWrite.signalAll();
        }finally {
            accessLock.unlock();
        }
    }
}

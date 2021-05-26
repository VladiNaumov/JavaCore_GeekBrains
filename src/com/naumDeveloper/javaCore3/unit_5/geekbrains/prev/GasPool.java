package com.naumDeveloper.javaCore3.unit_5.geekbrains.prev;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class GasPool {
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final float capacity = 200F;
    private float size = 200F;

    public float request(float amount) {
        lock.writeLock().lock();
        try {
            if (amount > size) {
                return 0F;
            }
            Thread.sleep(1500);
            size -= amount;
            return amount;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
        return 0F;
    }

    @Override
    public String toString() {
        return "GasPool{" +
                "capacity=" + capacity +
                ", size=" + size +
                '}';
    }
}

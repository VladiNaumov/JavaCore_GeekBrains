package naumDeveloper.javaCore3.unit_5.homework;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class GasPoolDemo {

    private float GasPoolCapacity = 200F;


    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public float requestFuel(float fuelAmount) {
        lock.writeLock().lock();

        if (fuelAmount > GasPoolCapacity) {
            System.out.println("На станции нет  в наличие столько топлива.....");
            return 0F;

        }else if (fuelAmount > GasPoolCapacity) {

            GasPoolCapacity -= fuelAmount;
            return fuelAmount;
        }
           lock.writeLock().unlock();

        return 0F;

        }

    }

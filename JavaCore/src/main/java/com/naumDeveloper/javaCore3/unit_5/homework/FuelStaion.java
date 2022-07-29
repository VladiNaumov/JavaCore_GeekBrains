package com.naumDeveloper.javaCore3.unit_5.homework;

/*
    FuelStaion одновременно может заправлять только 3 автомобиля, остальные должны пока не освободится место (порядок не имеет значения).
	При заправке автомобиля запрашивается необходимое количество топливо, которое поступает из GasPool.
	Необходимое топливо для автомобиля вычисляется на основании формулы R = C - F, где С это объем бака, а F - фактическое состояние бака
	Заправка занимает 5 сек, зачем транспортное средство освобождает место
 */

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class FuelStaion {

    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    private Semaphore semaphore;
    private GasPool gasPool;
    private float W;

    public FuelStaion(Semaphore semaphore, GasPool gasPool) {
        this.gasPool = gasPool;
        this.semaphore = semaphore;

    }


    // заправочная станция
    public float fuelStantionDoRefuel(float amount){
           try {
            semaphore.acquire();

            if(amount < gasPool.getGasPoolCapacity()) {
                W = gasPool.requestFuel(amount); // подключение к баллону с топливом
                System.out.println("Идёт заправка ");
                Thread.sleep(5000);
                gasPool.info();
            } else {
                System.out.println("На станции закончился бензин ");
                return 0;
            }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                semaphore.release(); // отключение баллона с топливом

            }

        return W;
    }

}

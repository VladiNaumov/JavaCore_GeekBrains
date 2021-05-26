package com.naumDeveloper.javaCore3.unit_5.geekbrains.prev;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        FuelStation fuelStation = new FuelStation();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(new Car("H4-881", fuelStation));
        executorService.submit(new Car("4SS-810", fuelStation));
        executorService.submit(new Car("DH8888", fuelStation));
        executorService.submit(new Car("AK89117BG", fuelStation));

        executorService.shutdown();
    }
}

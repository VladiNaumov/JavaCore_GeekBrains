package com.naumDeveloper.javaCore3.unit_5.geekbrains.road;

public class Car {
    private double size = 5D;

    public double getSize() {
        return size;
    }

    public void consume(double val) {
        size -= val;
    }
}

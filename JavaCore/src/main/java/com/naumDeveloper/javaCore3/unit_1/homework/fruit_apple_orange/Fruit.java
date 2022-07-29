package com.naumDeveloper.javaCore3.unit_1.homework.fruit_apple_orange;

public abstract class Fruit {

    protected int maara;
    protected int massa;


    public Fruit(int maara, int massa) {
        this.maara = maara;
        this.massa = massa;
    }


    public int getMassa() {
        int fullMassa= maara * massa;
        return fullMassa;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "massa=" + massa +
                '}';
    }
}

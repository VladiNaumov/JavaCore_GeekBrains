package com.naumDeveloper.javaCore3.unit_1.homework.fruit_apple_orange;

public class Oranges extends Fruit {


    public Oranges(int maara, int massa) {
        super(maara, massa);
    }

    @Override
    public int getMassa() {
        int fullMassa= maara * massa;
        return fullMassa;
    }
}

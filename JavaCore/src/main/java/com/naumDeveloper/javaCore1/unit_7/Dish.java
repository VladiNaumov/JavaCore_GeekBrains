package com.naumDeveloper.javaCore1.unit_7;

public class Dish {


    private int food;

    public int getFood() {
        return food;
    }
    public void saldo(int a){
        this.food = this.getFood() - a;

    }

    public Dish(int food) {
        this.food = food;

    }


}

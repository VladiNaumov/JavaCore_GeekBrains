package com.naumDeveloper.javaCore1.unit_6.entety;

// (бег: кот 200 м. прыжок: кот 2 м. плавание: кот не умеет плавать.

public class Cat extends Aninal {

    public Cat(String name) {
        this.name = name;
    }


    @Override
    public void runing(int runing) {
        if(runing <= 200){
            System.out.println( name + " RUNNING- " + true);
        }else{
            System.out.println(name + " RUNNING- " + false);
        }

    }

    @Override
    public void jumping( double jumping) {
        if(jumping <= 2){
            System.out.println(name + " JUMPING- " +true);
        } else{
        System.out.println(name + " JUMPING-  " + false);
        }
    }

    @Override
    public void swiming(int swiming) {
        if(swiming > 0){
            System.out.println(name + " SWIMING- " + false);
        }  else{
        System.out.println(name + " SWIMING- " + false);
        }
    }


}

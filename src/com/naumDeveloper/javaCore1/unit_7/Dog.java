package com.naumDeveloper.javaCore1.unit_7;

public class Dog extends Aninal {


    public Dog(String name) {
        this.name = name;
    }

    // собака 500 м.; прыжок: собака 0.5 м.; плавание:  собака 10 м.



    @Override
    protected void runing(int runing) {
        if(runing <= 500){
            System.out.println(name + " RUNNING- " + true);
        }else{
            System.out.println(name + " RUNNING- " + false);
        }
    }

    @Override
    protected void jumping(double  jumping) {
        if(jumping < 0.5) {
            System.out.println(name + " JUMPING- " + true);
        } else{
            System.out.println(name + " JUMPING- " + false);
        }
    }

    @Override
    protected void swiming(int swiming) {
        if(swiming <= 10){
            System.out.println(name + " SWIMING- " + true);
        }  else{
            System.out.println(name + " SWIMING- " + false);
        }
    }


}

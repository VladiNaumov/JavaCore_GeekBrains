package com.naumDeveloper.javaCore3.unit_1.homework.fruit_apple_orange;

public interface IBox<T> {

    //добовление фрукта в коробку
    void add(T fruct);


    // переложить фрукты в другой ящик
   // void moveTo( T otherBox);

    // высчитывает вес коробки
    int getWeightBox();

    //позволяет сравнить текущую коробку с той,которую подадут в compare в качестве параметра, true - если их веса равны, false
    boolean compare(Box<? extends Fruit> otherBox);

}

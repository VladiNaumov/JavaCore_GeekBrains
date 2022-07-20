package naumDeveloper.javaCore3.unit_1.homework.fruit_apple_orange;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> implements IBox<T> {

private List<T>boxFruits;

    public Box() {
        boxFruits = new ArrayList<>();
    }


    // добовление в box фруктов
    @Override
    public void add(T fruit) {
        boxFruits.add(fruit);
    }

    // переложить фрукты в другой ящик
    public void moveTo(Box<T> otherBox) {
        boxFruits.forEach(fruit -> otherBox.add(fruit));
    }

    // высчитывает вес коробки
    @Override
    public int getWeightBox() {
        int boxMassa = 0;
        for (Fruit f: boxFruits) {
            boxMassa += f.getMassa();
        }
      return boxMassa;
    }

    @Override
    public boolean compare(Box<? extends Fruit> otherBox) {
        return otherBox.getWeightBox() == getWeightBox();
    }

}

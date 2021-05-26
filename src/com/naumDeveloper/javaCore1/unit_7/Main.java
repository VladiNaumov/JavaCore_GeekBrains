package com.naumDeveloper.javaCore1.unit_7;


/*
        1. Расширить задачу про котов и тарелки с едой
        2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды, а кот пытается покушать 15-20)
        3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось покушать (хватило еды), сытость = true
        4. Считаем, что если коту мало еды в тарелке, то он ее просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы)
        5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию о сытости котов в консоль
        6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку

 */


public class Main {

    public static void main(String[] args) {
        int liha = 40;
        Dish food = new Dish(liha);

        Cat mur = new Cat("MURSIK", true, 10);

        System.out.println("Общее количество еды " + food.getFood());

        mur.runingEting(food);


        Cat[] myArray = new Cat[10];
        myArray[0] = new Cat("MURSIK", true, 10);
        myArray[1] = new Cat("MAKA", true, 10);
        myArray[2] = new Cat("Akku", true, 10);
        myArray[3] = new Cat("TIMO ", true, 10);
        myArray[4] = new Cat("DF", true, 10);
        myArray[5] = new Cat("MAKA", true, 10);
        myArray[6] = new Cat("MAR", true, 10);
        myArray[7] = new Cat("MRK", true, 10);
        myArray[8] = new Cat("MAKA", true, 10);
        myArray[9] = new Cat("MAR", true, 10);

        for (int i = 0; i < myArray.length; i++) {
          myArray[i].runingEting(food);

        }
        System.out.println("Остаток еды в тарелке- " + food.getFood());


    }
}

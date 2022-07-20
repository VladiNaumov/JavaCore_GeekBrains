package naumDeveloper.javaCore1.unit_7;

// (бег: кот 200 м. прыжок: кот 2 м. плавание: кот не умеет плавать.

/*
        1. Расширить задачу про котов и тарелки с едой
        2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды, а кот пытается покушать 15-20)
        3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось покушать (хватило еды), сытость = true
        4. Считаем, что если коту мало еды в тарелке, то он ее просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы)
        5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию о сытости котов в консоль
        6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку

 */

public class Cat extends Aninal {


    public Cat(String name, boolean nalka, int enough) {
        this.name = name;
        this.nalka = nalka;
        this.enough = enough;

    }

    protected void runingEting(Dish dish) {
        if(dish.getFood() >= enough && nalka == true ){
            dish.saldo(enough);
            nalka = false;
            System.out.println(name + " голодный: " + nalka );
        }else{
            System.out.println(name + " Хочу кушать, но еды мне не достаточно :( " );
        }

    }

    @Override
    protected void runing(int runing) {
        if(runing <= 200){
            System.out.println( name + " RUNNING- " + true);
        }else{
            System.out.println(name + " RUNNING- " + false);
        }

    }

    @Override
    protected void jumping( double jumping) {
        if(jumping <= 2){
            System.out.println(name + " JUMPING- " +true);
        } else{
        System.out.println(name + " JUMPING-  " + false);
        }
    }

    @Override
    protected void swiming(int swiming) {
        if(swiming > 0){
            System.out.println(name + " SWIMING- " + false);
        }  else{
        System.out.println(name + " SWIMING- " + false);
        }
    }


}

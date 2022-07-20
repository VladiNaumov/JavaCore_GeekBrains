package naumDeveloper.javaCore1.unit_5;

/*

* Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст;
* Конструктор класса должен заполнять эти поля при создании объекта;
* Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
* Создать массив из 5 сотрудников
Пример:
Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
persArray[1] = new Person(...);
...
persArray[4] = new Person(...);

* С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
 */
public class Main {

    public static void main(String[] args) {
        Employ secretary = new Employ("Nastya Pupkina", "Secretary", "www@link.ru", 8800777, 3000, 25 );
        secretary.print();
        System.out.println("******************************");



        Employ[] arrayEmploy = new Employ[5];
        arrayEmploy[0] = new Employ("Nastya Pupkina", "Secretary", "www@Helsinki.fi", 8800777, 3000, 25 );
        arrayEmploy[1] = new Employ("Vladimir Putin", "Prezedenty", "Putin@Helsinki.fi", 88997, 100000, 55 );
        arrayEmploy[2] = new Employ("Teemu Hämäläinen", "Koodari", "Dmitry@Helsinki.fi", 8800777, 3000, 37 );
        arrayEmploy[3] = new Employ("Timo Nostolahtiv", "IT engineer", "Gocha@Helsinki.fi", 8800777, 3000, 43 );
        arrayEmploy[4] = new Employ("Peetari Lambert ", "engineer", "Ivanov@Helsinki.fi", 8800777, 3000, 18 );


        for (Employ var :arrayEmploy) {
            if(var.getAge() > 40){
                System.out.println(var );
            }
        }
    }
}

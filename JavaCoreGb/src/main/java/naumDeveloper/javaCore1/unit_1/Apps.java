package naumDeveloper.javaCore1.unit_1;

public class Apps {
    // 1. Создать пустой проект в IntelliJ IDEA и прописать метод main();

    public void main(){

    }

    // 2. Создать переменные всех пройденных типов данных, и инициализировать их значения;

    byte a = 124;
    int b = 23222200;
    short c = 2377;
    long d = 12L;
    float e = 12.1f;
    double f = 122.0;
    char g = 'a';
    boolean aBoolean = true;
    boolean aNegative = false;

    // 3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,где a, b, c, d – входные параметры этого метода;
    public int abcd(int a, int b, int c, int d){

        return a * (b + (c / d));
    }

    //4. Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит в пределах от 10 до 20(включительно),
    // если да – вернуть true, в противном случае – false;

    public boolean verify (int z, int c){
        int summa = z + c;
        if(summa > 9 && summa <21){
            aBoolean = true;
        }else {
            aBoolean = false;
        }
        return aBoolean;
    }

    // 5. Написать метод, которому в качестве параметра передается целое число,
    // метод должен напечатать в консоль положительное ли число передали, или отрицательное; Замечание: ноль считаем положительным числом.

    public void numerot(int q){


        if (q >= 0){
            System.out.println("положительное число");
        }else{
            System.out.println("отрицательное число");
        }

    }

    // 6. Написать метод, которому в качестве параметра передается целое число, метод должен вернуть true, если число отрицательное;

    public boolean negative(int a){

        if(a < 0){
            aNegative = true;
        }

        return aNegative;
    }


    //   7. Написать метод, которому в качестве параметра передается строка, обозначающая имя, метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
    public void myString(String s){

        System.out.println("Привет," + s);
    }
}

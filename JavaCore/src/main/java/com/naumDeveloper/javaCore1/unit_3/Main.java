package com.naumDeveloper.javaCore1.unit_3;

/*
1. Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3 попытки угадать это число.
При каждой попытке компьютер должен сообщить больше ли указанное пользователем число чем загаданное, или меньше.
После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).


2 * Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь. Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.
apple – загаданное
apricot - ответ игрока
ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
Для сравнения двух слов посимвольно, можно пользоваться:
String str = "apple";
str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
Играем до тех пор, пока игрок не отгадает слово
Используем только маленькие буквы

 */

import java.util.Random;
import java.util.Scanner;

public class Main {

    public void randomNumber(int num){
        if(num == 1){
            loop();
       }
    }

    public  void loop(){

        Random random = new Random();

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число от 0 до 9");
        int number = random.nextInt(9);

        for (int i = 0; i < 3; i++ ) {


            int x = Integer.parseInt(sc.nextLine());

            if (number != x) {

                if (x < number) {
                    System.out.println("больше");
                } else {
                    System.out.println("меньше");
                }

            } else {

                System.out.println("Onnea! " + number);
                System.out.println("«Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет)");
                int num = sc.nextInt();
                randomNumber(num);
            }

        }

        System.out.println("Загаданный номер был: " + number);
        System.out.println("«Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет)");
        int num = sc.nextInt();
        randomNumber(num);

    }

    public static void main(String[] args) {
         new Main().randomNumber(1);
       }

}

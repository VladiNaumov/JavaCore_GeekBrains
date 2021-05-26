package com.naumDeveloper.javaCore1.unit_3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


/*

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



public class Prev {
    public static void main(String[] args) {
        char[] sharps = {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'};
        String[] secrets = {"apple", "banana", "truck"};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input your word...");

        String secret = secrets[new Random().nextInt(secrets.length)];
        System.out.println(secret);
        String guessWord = scanner.next().toLowerCase();
        char[] bufferedSharps = Arrays.copyOf(sharps, sharps.length);

        if (guessWord.equals(secret)) {
             bufferedSharps = guessWord.toCharArray();
        } else {
            /**
             * Option #1
             */
//            for (int i = 0; i < secret.length() && i < guessWord.length(); i++) {
//                if (guessWord.charAt(i) == secret.charAt(i)) {
//                    bufferedSharps[i] = guessWord.charAt(i);
//                }
//            }

            /**
             * Option #2
             */
            for (int i = 0; i < guessWord.length(); i++) {
                for (int j = 0; j < secret.length(); j++) {
                    if (guessWord.charAt(i) == secret.charAt(j)) {
                        bufferedSharps[j] = guessWord.charAt(i);
                    }
                }
            }
        }

        for (int i = 0; i < bufferedSharps.length; i++) {
            System.out.print(bufferedSharps[i]);
        }
        System.out.println();
    }
}

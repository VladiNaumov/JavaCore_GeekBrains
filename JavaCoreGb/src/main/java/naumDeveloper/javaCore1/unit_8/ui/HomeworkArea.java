package naumDeveloper.javaCore1.unit_8.ui;

import java.util.Random;
import java.util.Scanner;

public class HomeworkArea {
    public static void main(String[] args) {
        System.out.println("Задание 1:");
        game1();
    }

    public static void game1() {
        Random random = new Random();
        int n = random.nextInt(10);
        System.out.println("Загадано число n от 0 до 9." + n);
        Scanner sc1 = new Scanner(System.in);
        int number;
        for (int i = 0; i < 3; i++) {
            System.out.printf("\tОсталось попыток: %d", 3 - i);
            System.out.print("\n\tВведите предпологаемое число: ");
            number = sc1.nextInt();
            if (number < n) {
                System.out.println("\tУказанное число меньше загаданного.");
            } else if (number > n) {
                System.out.println("\tУказанное число больше загаданного.");
            } else {
                System.out.println("Поздравляю, вы угадали загаданное число n = " + n);
                break;
            }
            if (i == 2) {
                System.out.println("Вы проиграли. Было загадано число n = " + n);
            }
        }
//        System.out.println("Повторить игру еще раз? 1 – да / 0 – нет»");
//        Scanner sc2 = new Scanner(System.in);
//        int newGame = sc2.nextInt();
//        sc2.close();
//        if (newGame == 1) {
//            System.out.println("Выбрана новая игра.");
//            game1();
//        } else if (newGame == 0) {
//            System.out.println("Игра окончена.");
//        }
        sc1.close();
        game1();
    }
}

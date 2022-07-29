package naumDeveloper.javaCore1.unit_3;

import java.util.Random;
import java.util.Scanner;

//      1. Написать программу, которая загадывает случайное число от 0 до 9 и пользователю дается 3 попытки угадать это число.
//      При каждой попытке компьютер должен сообщить, больше ли указанное пользователем число, чем загаданное, или меньше.
//      После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).

public class App {

    public static void main(String[] args) {
        new App().game();
    }

    public void game() {
        Scanner scan = new Scanner(System.in);
        String answer = "";
        Random random = new Random();
        int x, y;

        while (!answer.equals("0")) {
            x = random.nextInt(9);
            int count = 1;
            for (int i = 0; i < 3; i++, count++) {
                while (true) {
                    System.out.print("Твоя попытка: ");
                    answer = scan.nextLine();
                    try {
                        y = Integer.parseInt(answer);
                        break;
                    } catch (NumberFormatException ex) {
                        System.out.println("Ты ввел какую-то дичь!");
                    }
                }
                if (x != y) {
                    System.out.println(y > x ? "Больше!" : "Меньше!");
                } else {
                    System.out.printf("Угадал с %d попытки!\n", count);
                    break;
                }
            }

            System.out.print("Еще раз? 0-нет ");
            answer = scan.nextLine();
        }
        System.out.println("Пока !!!");
    }
}




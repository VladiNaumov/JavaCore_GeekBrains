package com.naumDeveloper.javaCore1.unit_4;

import java.util.Random;
import java.util.Scanner;

/*
1. Полностью разобраться с кодом, попробовать переписать с нуля, стараясь не подглядывать в методичку;
2. Доработать проверку побегу по диагоналям.
3. * Попробовать переписать программу так, чтобы она работала с разным равномерным размером полей. При этом пользователю предоставляется возможность задать размер поля. Например, 5х5, 10х10 и так далее. 4х3 считает недопустимым.
4. *** Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока.
 */

public class Main {

    public static void main(String[] args) throws InterruptedException {


        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

       new Game().play(scanner, random);



    }


}

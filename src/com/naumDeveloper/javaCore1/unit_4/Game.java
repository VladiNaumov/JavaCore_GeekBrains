package com.naumDeveloper.javaCore1.unit_4;

import java.util.Random;
import java.util.Scanner;

/*
1. Полностью разобраться с кодом, попробовать переписать с нуля, стараясь не подглядывать в методичку;
2. Доработать проверку побегу по диагоналям.

3. * Попробовать переписать программу так, чтобы она работала с разным равномерным размером полей.
При этом пользователю предоставляется возможность задать размер поля. Например, 5х5, 10х10 и так далее. 4х3 считает недопустимым.

4. *** Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока.

 */


public class Game {

    private int xArray;
    private int yArray;


    // создание игровой карты (массива)
    public char[][] getField(int x, int y) {

        char[][] myArray = new char[x][y];
        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray.length; j++) {
                myArray[j][i] = '-';
            }
        }
        return myArray;
    }

    // запуск игра (инициализация)
    public void play(Scanner scanner, Random random) throws InterruptedException {

        do {
            System.out.println("Выберите размер доски по Х  ... ");
            xArray = scanner.nextInt();
            System.out.println("Выберите размер доски по Y  ... ");
            yArray = scanner.nextInt();
        } while (xArray != yArray);

        System.out.println("инициализация поля прошла успешно");

        char[][] field = getField(xArray, yArray);
        drawField(field);

        do {
            doPlayerMove(scanner, field);
            if (isFinal(field, 'X')) {
                break;
            }

            doAIMove(random, field);
            if (isFinal(field, 'O')) {
                break;
            }
            drawField(field);
        } while (true);

        System.out.println("Final score");
        drawField(field);
    }

    // отвечает за границы массива
    public int getCoordinate(Scanner scanner, char coordName) {
        int coord;
        do {
            System.out.println(String.format("Please input %s-coordinate in range ...", coordName));
            /**
             * Получение значения от пользователя в даипазоне [1, 3] и
             * последующая конвертация в индексы массива
             */
            coord = scanner.nextInt() - 1;
        } while (coord < 0 || coord > this.xArray);
        return coord;
    }

    // ход компьютера
    public void doAIMove(Random random, char[][] field) throws InterruptedException {
        int x, y;
        do {
            System.out.println("ХОДИТ AI");
            Thread.sleep(500);
            x = random.nextInt(this.xArray);
            y = random.nextInt(this.xArray);

            System.out.println("ХОД AI " + x + " " + y);

        } while (field[x][y] != '-');
        field[x][y] = 'O';
    }


    // метод окончание игры
    static boolean isFinal(char[][] field, char sign) {
        if (myIsWin(field, sign)) {
            String name = sign == 'X' ? "Vladimir" : "AI";
            System.out.println(String.format("%s won!", name));
            return true;
        }
        if (isDraw(field)) {
            System.out.println("Обнаружена ничья. Слава богу, никто не выиграл!");
            return true;
        }
        return false;
    }


    // проверка условий (1)
    static boolean myIsWin(char[][] field, char sign) {

        boolean isWin = true;

// horizontal "Y"
        for (char[] line : field) {
            for (char item : line) {
                if (item != sign) {
                    isWin = false;
                    break;
                }
            }
            if (isWin) return true;
            isWin = true;
        }

// vertical "X"
        for (int i = 0; i < field[0].length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field[j][i] != sign) {
                    isWin = false;
                    break;
                }
            }
            if (isWin) return true;
            isWin = true;
        }

// diagonal 1
        int index = 0;
        while (index < field[0].length) {
            if (field[index][index] != sign) {
                isWin = false;
                break;
            }
            index++;
        }
        if (isWin) return true;
        isWin = true;

// diagonal 2
        for (int i = 0; i < field.length; i++) {
            int len = field[i].length - 1;

            if (field[i][len - i] != sign) {
                isWin = false;
                break;
            }
        }

        return isWin;
    }

    // проверка условий (2)
    static boolean checkWin(char[][] field, char sign) {
        boolean farr[][] = new boolean[field.length][field.length];//логический массив
        boolean diagonal = true;//проверка диагонали
        boolean reDiagonal = true; //проверка обратной диагонали
        boolean col;//проверка столбцов
        boolean row;// проверка строк
        boolean check = false;// общая проверка
        for (int i = 0; i < farr.length; i++) {// перевод массива в булеан переменные
            for (int j = 0; j < farr.length; j++) {
                farr[i][j] = (field[i][j] == sign);

            }

        }
        for (int i = 0; i < farr.length; i++) {
            diagonal = diagonal & farr[i][i];
            reDiagonal = reDiagonal & farr[i][farr.length - i - 1];
        }
        for (int i = 0; i < farr.length; i++) {
            col = true;
            row = true;
            for (int j = 0; j < farr.length; j++) {
                col = farr[j][i] & col;
                row = farr[i][j] & row;
            }
            check = col | row | check;
        }
        check = check || diagonal || reDiagonal;

        return check;
    }

/*
    public static boolean checkWin(char symbol) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j <= 0; j++) {
                if (map[i][j] == symbol && map[i][map[i].length - 2] == symbol && map[i][map[i].length - 1] == symbol) {
                    return true;
                } else if (map[j][i] == symbol && map[map[i].length - 2][i] == symbol && map[map[i].length - 1][i] == symbol) {
                    return true;
                } else if (map[j][j] == symbol && map[map[i].length - 2][map[i].length - 2] == symbol && map[map[i].length - 1][map[i].length - 1] == symbol) {
                    return true;
                } else if (map[j][map[i].length - 1] == symbol && map[map[i].length - 2][map[i].length - 2] == symbol && map[map[i].length - 1][j] == symbol) {
                    return true;
                }
            }
        }return false;
    }

    public static boolean checkWin(char symbol) {
        for (int i = 0; i < map.length; i++){
            for (int j = 0; j <= 0; j++){ if (map[i][j] == symbol && map[i][j + 1] == symbol && map[i][j + 2] == symbol){
                return true; } else if (map[j][i] == symbol && map[j + 1][i] == symbol && map[j + 2][i] == symbol){
                return true; } else if (map[j][j] == symbol && map[j + 1][j + 1] == symbol && map[j + 2][j + 2] == symbol){
                return true; } else if (map[j][j + 2] == symbol && map[j + 1][j + 1] == symbol && map[j + 2][j] == symbol){
                return true; } } } return false;
    }

 */


    static boolean isDraw(char[][] field) {
        int count = field.length * field.length;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field[i][j] != '-') {
                    count--;
                }
            }
        }
        return count == 0;
    }


    public void doPlayerMove(Scanner scanner, char[][] field) {
        int x, y;
        do {
            y = getCoordinate(scanner, 'X');
            x = getCoordinate(scanner, 'Y');
        } while (field[x][y] != '-');
        field[x][y] = 'X';
    }


    public void drawField(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
   }

// ПЕРВЫЙ СПОСОБ ПРОВЕРКИ
       public boolean isWin(char[][] field, char sign) {
        /**
         * Проверка на горизонталь Y
         */
        for (int i = 0; i < field.length; i++) {
            if (field[i][0] == sign && field[i][1] == sign && field[i][2] == sign) {
                return true;
            }
        }

        /**
         * Проверка на вертикаль X
         */
        for (int i = 0; i < field.length; i++) {
            if (field[0][i] == sign && field[1][i] == sign && field[2][i] == sign) {
                return true;
            }
        }

        // Проверка на диагональ->
        if (field[0][0] == sign && field[1][1] == sign && field[2][2] == sign) {
            return true;

        }
        // Проверка на диагональ <-
        if (field[2][0] == sign && field[1][1] == sign && field[0][2] == sign) {
            return true;
        }

        return false;
    }

}

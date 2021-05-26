package com.naumDeveloper.javaCore1.unit_4;


import java.util.Random;
import java.util.Scanner;

public class Games_v1 {

        public static void main(String[] args) {
            start();
        }

        static void start() {
            char[][] field = createField();

            while (true) {

                drawField(field);

                doPlayerMove(field);
                if (checkWin(field, 'X')) {
                    System.out.println("Congrats!!!");
                    System.out.println("Player is winner!!!");
                    break;
                }
                if (checkDraw(field)) {
                    System.out.println("Sorry, game is draw!!!");
                    System.out.println("Bey!!!");
                    break;
                }

                doAIMove(field);
                if (checkWin(field, 'O')) {
                    System.out.println("Sorry!!!");
                    System.out.println("AI is winner!!!");
                    break;
                }
                if (checkDraw(field)) {
                    System.out.println("Sorry, game is draw!!!");
                    System.out.println("Bey!!!");
                    break;
                }
            }
        }

        static boolean checkDraw(char[][] field) {
            int freeCells = field.length * field.length;

            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field[i].length; j++) {
                    if (field[i][j] != '-') {
                        freeCells--;
                    }
                }
            }

            return freeCells == 0;
        }

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


        static void doPlayerMove(char[][] field) {
            int x, y;

            do {
                x = chooseCoordinate(field.length, 'X');
                y = chooseCoordinate(field.length, 'O');
            } while (field[x][y] != '-');

            field[x][y] = 'X';

            drawField(field);
            drawSeparator();
        }

        static void doAIMove(char[][] field) {
            Random random = new Random();
            int x, y;

            do {
                x = random.nextInt(field.length);
                y = random.nextInt(field.length);
            } while (field[x][y] != '-');

            field[x][y] = 'O';
            drawField(field);
            drawSeparator();
        }

        static int chooseCoordinate(int maxLength, char sign) {
            Scanner scanner = new Scanner(System.in);

            int coord;
            do {
                System.out.printf("Please enter %s-coord in range [1..3]%n", sign);
                coord = scanner.nextInt() - 1;
            } while (coord < 0 || coord >= maxLength);

            return coord;
        }

        static char[][] createField() {
            return new char[][]{
                    {'-', '-', '-'},
                    {'-', '-', '-'},
                    {'-', '-', '-'}
            };
        }

        static void drawSeparator() {
            for (int i = 0; i < 2; i++) {
                System.out.println();
            }
        }

        static void drawField(char[][] field) {
            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field[i].length; j++) {
                    System.out.print(field[i][j]);
                }
                System.out.println();
            }
        }
    }



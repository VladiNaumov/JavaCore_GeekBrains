package naumDeveloper.javaCore1.unit_2;

import java.util.Arrays;

public class ArrayApp {


    //    1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;

    public void myArrayZeroOne() {
        int[] myArray = {1, 0, 0, 1, 1, 0, 1, 1, 0, 1};

        for (int i = 0; i < myArray.length; i++) {
            if ((myArray[i]) == 0) {
                myArray[i] = 1;
            } else {
                myArray[i] = 0;
            }

        }
        for (int i = 0; i < myArray.length; i++) {
            System.out.print(myArray[i] + " ");
        }
    }

    // 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
    public void myArrayMinimumSix() {

        int[] myArray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < myArray.length; i++) {
            if ((myArray[i]) < 6) {
                myArray[i] = (myArray[i] * 2);
           }
        }

        for (int i = 0; i < myArray.length; i++) {
            System.out.print(myArray[i] + " ");
        }

    }

    // 2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;

    public void myArrayСreature(){
        int[] myArray = new int[8];

        for (int i = 1; i < myArray.length; i++) {
            myArray[i] = i * 3;
        }


        for (int i = 0; i < myArray.length; i++) {
        System.out.print(myArray[i] + " ");
        }

    }


    //5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
    public void arrayMinMax(){
        int max = -2147483648;
        int min = 2147483647;

         int[] myArray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1,25, 7, 99, 35};

         for (int i = 0; i < myArray.length; i++) {

             max =  myArray[i] > max ? myArray[i] : max ;

             min =  myArray[i] < min ? myArray[i] : min ;

         }

        System.out.println("MAX " + max);
        System.out.print("MIN " + min);
    }

    // 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;

    public void twoArray(){

        int[][] myArray = new int[5][5];


        for (int i = 0; i < myArray.length; i++) {
            myArray[i][i] = 1;
            for (int j = 0; j < myArray[i].length; j++) {

           }
        }


        for (int i = 0; i < myArray.length; i++){
            for(int j=0; j < myArray[i].length; j++){

                System.out.printf("%d ", myArray[i][j]);
            }
            System.out.println();
        }

        // МОЖЕТЕ НЕМНОГО ОБЪЯСНИТЬ ПОЧЕМУ?
        System.out.println(Arrays.toString(myArray)); //вычитал что этот метод показывает весь массив (без использования циклов), но он показывает только ссылку на массив с ячейками в памяти


    }
}

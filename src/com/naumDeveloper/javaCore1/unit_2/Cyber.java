package com.naumDeveloper.javaCore1.unit_2;

import java.util.Arrays;

public class Cyber {

//    7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным), при этом метод должен сместить все элементымассива на n позиций. Для усложнения задачи нельзя пользоваться вспомогательными массивами.


    public static void main(String[] args) {
            int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
            System.out.println(Arrays.toString(a));
            foo(a, 3);
            System.out.println(Arrays.toString(a));
            foo(a, -6);
            System.out.println(Arrays.toString(a));


        }

        public static void foo(int[] arr, int n) {
            int temp;
            int len = arr.length - 1;
            if (n < 0) {
                for (int i = 0; i < -n; i++) {
                    temp = arr[0];
                    System.arraycopy(arr, 1, arr, 0, len);
                    arr[len] = temp;
                }
            } else {
                for (int i = 0; i < n; i++) {
                    temp = arr[len];
                    System.arraycopy(arr, 0, arr, 1, len);
                    arr[0] = temp;
                }
            }
        }
}

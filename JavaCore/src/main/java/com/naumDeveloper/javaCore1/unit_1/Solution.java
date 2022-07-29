package com.naumDeveloper.javaCore1.unit_1;

public class Solution {
    /*
    8. * Написать метод, который определяет является ли год високосным, и выводит сообщение в консоль.
    Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
*/
    

        public static void main(String[] args) throws Exception {


            int year= 2001;


            if (year %100==0 && year %400 ==0 )
                System.out.println("год является високосным");

            else if (year % 4 == 0 && year % 100 > 0)
                System.out.println("год является високосным");

            else if (year % 100 == 0)
                System.out.println("обычный год");

            else
                System.out.println("обычный год");
        }
}

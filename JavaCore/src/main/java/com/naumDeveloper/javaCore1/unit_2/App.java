package com.naumDeveloper.javaCore1.unit_2;

public class App {

     //   6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
    //   Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы в массив не входят.


    public void Main()
        {
            int[] arr = { 1, 2, 1, 0, 4 };

            System.out.println(CheckBalanceArray(arr));
        }

        static boolean CheckBalanceArray(int[] arr)
        {
            // изначально баланс ещё не найден
            boolean balanceExist = false;

            // сразу находим сумму всех элементов в массиве
            int arrSum = 0;
            for(int i : arr)
            {
                arrSum += i;
            }

            // проходим по массиву ещё раз и собираем сумму на каждой итерации (правую часть массива)
            int rightSum = 0;
            for (int i = 0; i < arr.length; i++)
            {
                // добавляем текущее значение в сумму правой части
                rightSum += arr[i];

                // вычитаем из суммы всего массива, сумму текущей правой части,
                // и если они равны, значит баланс найден.
                if (rightSum == arrSum - rightSum)
                {
                    balanceExist = true;

                    //следующие две строки можно удалить, они просто выводят в консоль массив с текущим разделителем.
                    System.out.println("Найден баланс:");
                    WriteArrayWithBorder(arr, i, "||");
                }
            }

            return balanceExist;
        }

        //этот метод не обязателен, он выводит в консоль массив с текущим разделителем.
        static void WriteArrayWithBorder(int[] arr, int borderAfterInd, String borderSymbol)
        {
            for (int i = 0; i < arr.length; i++)
            {
                System.out.println(arr[i] + " ");
                if (i == borderAfterInd)
                {
                    System.out.print(borderSymbol + " ");
                }
            }

          //  System.out.println(Environment.NewLine);
        }
    }


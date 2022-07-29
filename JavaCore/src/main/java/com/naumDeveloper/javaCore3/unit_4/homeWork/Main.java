package com.naumDeveloper.javaCore3.unit_4.homeWork;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
    Создать три потока, каждый из которых выводит определенную букву (A, B и C)
    5 раз (порядок – ABСABСABС). Используйте wait/notify/notifyAll.
*/

public class Main {
    public static void main(String[] args) {
        startThreads();
    }

    private synchronized static void startThreads() {

        SinhronaizerManager manager = new SinhronaizerManager();

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        ThreadA a = new ThreadA(manager);
        ThreadB b = new ThreadB(manager);
        ThreadC c = new ThreadC(manager);
        executorService.submit(a);
        executorService.submit(b);
        executorService.submit(c);
        executorService.shutdown();



    }
}

package com.naumDeveloper.javaCore3.unit_4.homeWork;

public class ThreadB extends Thread implements Runnable{


    public ThreadB(SinhronaizerManager manager) {
        super(manager);
    }

    @Override
    public void run() {
        while (counter > 0) {
            manager.showB();
            counter--;
        }
    }
}

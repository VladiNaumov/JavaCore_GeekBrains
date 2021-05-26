package com.naumDeveloper.javaCore3.unit_4.homeWork;

public class ThreadC extends java.lang.Thread implements Runnable {

    public ThreadC(SinhronaizerManager manager) {
        super(manager);
    }

    @Override
    public void run() {
        while (counter > 0) {
            manager.showC();
            counter--;
        }
    }
}

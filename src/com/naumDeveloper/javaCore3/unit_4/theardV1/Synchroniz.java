package com.naumDeveloper.javaCore3.unit_4.theardV1;


// Синхронизатор
public class Synchroniz {
    private String data;
    private boolean isTransfer = true;

    public synchronized void transmit(String data) {
        System.out.println(String.format("[%s] Transmit preparation...", Thread.currentThread().getName()));
        while (!isTransfer) {
            try {
                System.out.println((String.format("[%s] Waiting for a free window...", Thread.currentThread().getName())));
                wait();
            } catch (Exception e) {
                Thread.currentThread().interrupt();
                System.out.println("SWW since thread was interrupted");
            }
        }

        isTransfer = false;
        this.data = data;

        System.out.println((String.format("[%s] Data prepared to transmit...", Thread.currentThread().getName())));
        notifyAll();
    }

    public synchronized String receive() {
        System.out.println(String.format("[%s] Receive preparation...", Thread.currentThread().getName()));
        while (isTransfer) {
            try {
                System.out.println((String.format("[%s] Waiting for data to be received...", Thread.currentThread().getName())));
                wait();
            } catch (Exception e) {
                Thread.currentThread().interrupt();
                System.out.println("SWW since thread was interrupted");
            }
        }

        isTransfer = true;

        notifyAll();
        System.out.println((String.format("[%s] Data successfully received...", Thread.currentThread().getName())));

        return data;
    }
  
}

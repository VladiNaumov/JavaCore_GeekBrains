package com.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class Client {
    private Socket  socket;
    private DataInputStream input;
    private DataOutputStream output;
    Scanner scanner =  new Scanner(System.in);
    public Client(){

        try {
            // Создаём подключение
            System.out.println("Socket is starting up... ");
            socket = new Socket("localhost",8189);
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());

            AtomicBoolean isDrop = new AtomicBoolean(false);

            //получение информции
            new Thread(() -> {
                try {
                    while (true) {
                        String incomingMassege = input.readUTF();
                        if (incomingMassege.contains("cmd Exit")) {
                            System.out.println(incomingMassege);
                            System.out.println("Please press enter to close command line...");
                            isDrop.set(true);
                            break;
                        }
                        System.out.println(incomingMassege);
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }
            }).start();

            //отправка информции
            while (true){
                if (isDrop.get()){
                    System.out.println("Closing....");
                    break;
                }
                System.out.println("Please type in a message .... ");
                // отправка сообщений
                output.writeUTF(scanner.nextLine());
              }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    // закрытие потоков.
    public void closeConnection(){

        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

 }



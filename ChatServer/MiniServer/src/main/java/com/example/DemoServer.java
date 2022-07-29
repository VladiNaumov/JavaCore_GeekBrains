package com.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class DemoServer {

    /*реализация простого сервера с возможностью подключения нескольких клиентов и отправки сообчения с сервера клиенту*/

        private static final String AUTH_CMD_PREFIX = "/auth"; // + login + password
        private static final int SERVER_PORT = 8186;
        private static DataInputStream in;
        private static DataOutputStream out;
        private static Socket clientSocket;
        public static Scanner sc = new Scanner(System.in);

        public static void main(String[] args) {

            try(ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
                while (true) {
                    System.out.println("Ожидание подключения...");
                    clientSocket = serverSocket.accept();
                    System.out.println("Подключение установлено!");

                    in = new DataInputStream(clientSocket.getInputStream());
                    out = new DataOutputStream(clientSocket.getOutputStream());

                    /* для подключение клиента и отправки сообщения обратно клиенту */
                    Thread t1 = new Thread(() -> {
                        try {
                            while (true) {
                                String message = in.readUTF();

                                if (message.equals("/stop")) {
                                    System.out.println("Сервер остановлен");
                                    System.exit(0);
                                }

                                if(message.startsWith(AUTH_CMD_PREFIX)){
                                    String[]  messageParts = message.split("\\s+");
                                    System.out.println("LOGIN: " + messageParts[1]);
                                    System.out.println("PASSPORT: " + messageParts[2]);
                                }

                                // для получения сообщений от клиента
                                System.out.println("Клиент: " + message);

                                // для отправки сообщений с сервера клиенту
                                out.writeUTF(" Server:   " + message.toUpperCase());

                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        } finally {
                            try {
                                clientSocket.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });

                    // для отправки сообщений с сервера клиенту
                    Thread t2 = new Thread(() -> {
                        while (true) {
                            // для отправки сообщений с сервера клиенту
                            sendMessage();
                        }
                    });
                    t1.setDaemon(true);
                    t2.setDaemon(true);
                    t1.start();
                    t2.start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // для отправки сообщений с сервера клиенту
        private static void sendMessage() {
            String message = sc.nextLine();

            try {
                out.writeUTF(" Server:   " + message.toUpperCase());
                System.out.println("Сообщение для пользователя: " + message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}


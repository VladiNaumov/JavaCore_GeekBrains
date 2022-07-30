package com.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/*реализация простого сервера с возможностью подключения нескольких клиентов и отправки сообчения с сервера клиенту*/
public class MiniServer {
    private String AUTH = "/auth"; // + login + password
    private int SERVER_PORT = 8189;
    private DataInputStream in;
    private  DataOutputStream out;
    private Socket clientSocket;

    private ServerSocket serverSocket;
    public static Scanner sc = new Scanner(System.in);

    public MiniServer() throws IOException {
        serverSocket = new ServerSocket(SERVER_PORT);
        while (true) {
                System.out.println("Ожидание подключения SERVER_PORT..." + SERVER_PORT);
                clientSocket = serverSocket.accept();
                System.out.println("Подключение установлено! "  );

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

                            if(message.startsWith(AUTH)){
                                String[]  messageParts = message.split("\\s+");
                                System.out.println("LOGIN: " + messageParts[1]);
                                System.out.println("PASSPORT: " + messageParts[2]);
                            }

                            // для получения сообщений от клиента
                            System.out.println("Клиент: " + message);

                            // для отправки сообщений с сервера клиенту
                            out.writeUTF("Server ECHO:   " + message.toUpperCase());

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

    }

    // для отправки сообщений с сервера клиенту
    private void sendMessage() {
        String message = sc.nextLine();

        try {
            out.writeUTF(" Server:   " + message.toUpperCase());
            System.out.println("Сообщение для пользователя: " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

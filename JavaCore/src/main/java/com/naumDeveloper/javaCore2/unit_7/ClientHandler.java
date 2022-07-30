package com.naumDeveloper.javaCore2.unit_7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private String AUTH = "/AUTH"; // + login + password
    private Server server;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private String username;

    public String getUsername() {
        return username;
    }


    public ClientHandler(Server server, Socket socket) throws IOException {
        this.server = server;
        this.socket = socket;
        this.in = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());

        new Thread(() -> {
            try {
                //
                // Цикл общения с клиентом
                while (true) {

                    String message = in.readUTF();

                    // если получим сообщение /STOP
                    if (message.equals("/STOP")) {
                        System.out.println("Сервер остановлен");
                        System.exit(0);
                    }

                    // если получим сообщение /AUTH
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
                disconnect();
            }
        }).start();
    }

    public void sendMessage(String message) throws IOException {
        out.writeUTF(message);
    }

    public void disconnect() {
        server.unsubscribe(this);
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

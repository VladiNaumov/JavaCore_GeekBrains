package com.example;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Network {
    public static final String DEFAULT_HOST = "localhost";
    public static final int DEFAULT_PORT = 8186;

    private final String host;
    private final int port;
    private DataOutputStream out;
    private DataInputStream in;
    private ChatController chatController;

    public Network(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public Network() {
        this(DEFAULT_HOST, DEFAULT_PORT);
    }

    public void connect() {
        try {
            Socket socket = new Socket(host, port);

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());


        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Соединение не установлено");
        }
    }

    public void sendMessage(String message) {
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ошибка при отправке сообщения");
        }
    }

    public void waitMessage(ChatController chatController) {
        Thread t = new Thread(() -> {
            try {
                while (true) {
                    String message = in.readUTF();
                    chatController.appendMessage("Я: " + message);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        t.setDaemon(true);
        t.start();
    }

}

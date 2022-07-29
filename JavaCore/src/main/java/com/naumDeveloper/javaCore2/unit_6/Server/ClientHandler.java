package com.naumDeveloper.javaCore2.unit_6.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    /* Класс отвечающий за авторизацию клеента к сервера и создание отдельного потока подключения к серверу */
    private Server server;
    private Socket clientSocket;
    private DataInputStream in;
    private DataOutputStream out;
    private String username;
    private boolean on = true;

    public ClientHandler(Server server, Socket socket) throws IOException {
        this.server = server;
        this.clientSocket = socket;
        this.in = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());
        in = new DataInputStream(clientSocket.getInputStream());
        out = new DataOutputStream(clientSocket.getOutputStream());


        /*создание отдельного потока подключения к серверу * (Multi eho server)*/
        new Thread(() -> {

            while (true) {

                String msg = null;
                try {
                    msg = in.readUTF();
                    out.writeUTF("Echo: " + msg);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("client wrote " + msg);

            }


        }).start();
    }

}

package com.naumDeveloper.javaCore2.unit_6.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/* Класс отвечающий за создание отдельного потока подключения к серверу, для подключения к серверу нескольких клиентов  */
public class ClientHandler {
    private Server server;
    private Socket clientSocket;
    private DataInputStream in;
    private DataOutputStream out;

    public ClientHandler(Server server, Socket socket) throws IOException {
        this.server = server;
        this.clientSocket = socket;
        this.in = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());
        in = new DataInputStream(clientSocket.getInputStream());
        out = new DataOutputStream(clientSocket.getOutputStream());


        /*создание отдельного потока подключения к серверу */
        new Thread(() -> {

            while (true) {

                String msg = null;
                try {
                    msg = in.readUTF();
                    out.writeUTF("Echo: " + msg);

                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    disconnect();
                }

                System.out.println("client wrote " + msg);

            }


        }).start();
    }

    public void disconnect() {

        if (clientSocket != null) {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

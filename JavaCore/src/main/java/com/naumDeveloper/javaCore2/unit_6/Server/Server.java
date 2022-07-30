package com.naumDeveloper.javaCore2.unit_6.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private int port = 8189;
    private List<ClientHandler> clients;

    private Socket clientSocket;
    private ServerSocket serverSocket;
    private DataInputStream in;
    private DataOutputStream out;

    public Server() {
        clients = new ArrayList<>();

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Сервер запущен на порту " + port);
            while (true) {
                System.out.println("Ждем нового клиента..");
                clientSocket = serverSocket.accept();
                System.out.println("Клиент подключился " + port);

                 new ClientHandler(this, clientSocket);
                 //subscribe(new ClientHandler(this,clientSocket ));
                 //ClientHandler(clientSocket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void subscribe(ClientHandler clientHandler) {
        clients.add(clientHandler);
    }


    // создание отдельного потока для подключения к серверу нескольких клиентов
    public void ClientHandler(Socket clientSocket) throws IOException {
        in = new DataInputStream(clientSocket.getInputStream());
        out = new DataOutputStream(clientSocket.getOutputStream());
        /*создание отдельного потока подключения к серверу */
        new Thread(() -> {

            while (true) {
                String msg = null;
                try {
                    msg = in.readUTF();
                    out.writeUTF("ECHO: " + msg);

                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    disconnect();
                }

                System.out.println("CLIENT WROTE: " + msg);

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

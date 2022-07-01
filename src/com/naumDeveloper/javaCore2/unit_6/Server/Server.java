package com.naumDeveloper.javaCore2.unit_6.Server;


import com.naumDeveloper.javaCore2.unit_6.Server.original.ClientHandler__;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private int port = 8189;
    private List<ClientHandler> clients;

    ServerSocket serverSocket;

    public Server() {
        this.clients = new ArrayList<>();

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Сервер запущен на порту " + port);
            while (true) {
                System.out.println("Ждем нового клиента..");
                Socket socket = serverSocket.accept();
                System.out.println("Клиент подключился " + port);
                new ClientHandler(this, socket);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void unsubscribe(ClientHandler clientHandler) {
    }

    public boolean isNickBusy(String usernameFromLogin) {
        return true;
    }


    public void broadcastMessage(String s) {
    }

    public void subscribe(ClientHandler__ clientHandler__) {
    }
}

package org.example.server;

import com.example.hendlers.ClientHandler;
import com.example.services.AuthenticationService;
import com.example.services.SimpleAuthenticationServiceImpl;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


/* задача этого класса принимать подключение и создание ClientHandler  */
public class MyServer {

    private final ServerSocket serverSocket;
    private final AuthenticationService authenticationService;
    private final ArrayList<ClientHandler> clients;

    public MyServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);

        // тип аутентификации
        authenticationService = new SimpleAuthenticationServiceImpl();
       // authenticationService = new SqlAuthenticationServiceImpl();

        //сохранения подключенных (которые сейчас в сети )
        clients = new ArrayList<>();
    }

    // подключение клиентов
    public void start() {
        System.out.println("CЕРВЕР ЗАПУЩЕН!");
        System.out.println("---------------");

        try {
            while (true) {
                waitAndProcessNewClientConnection();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // waitAndProcessNewClientConnection() - метод ожидания  подключения клиента
    private void waitAndProcessNewClientConnection() throws IOException {
        System.out.println("Ожидание клиента...");
        Socket socket = serverSocket.accept();
        System.out.println("Клиент подключился!");

        processClientConnection(socket);

    }

    // метод подключения клиента
    private void processClientConnection(Socket socket) throws IOException {
        ClientHandler handler = new ClientHandler(this, socket);
        handler.handle();
    }

    // подключившихся клиентов добавляем в в ArrayList
    public synchronized void subscribe(ClientHandler handler) {
        clients.add(handler);
    }

    // удаление отключившихся клиентов
    public synchronized void unSubscribe(ClientHandler handler) {
        clients.remove(handler);
    }


    public AuthenticationService getAuthenticationService() {
        return authenticationService;
    }

    // проверка на уже залогинившегося пользователя
    public boolean isUsernameBusy(String username) {
        for (ClientHandler client : clients) {
            if (client.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public void stop() {

        System.out.println("------------------");
        System.out.println("------------------");
        System.out.println("ЗАВЕРШЕНИЕ РАБОТЫ");
        System.exit(0);
    }

    public void broadcastMessage(ClientHandler sender, String message) throws IOException {

        for (ClientHandler client : clients) {
            if (client == sender) {
                continue;
            }
            client.sendMessage(sender.getUsername(), message);
        }

    }
	
	 public synchronized void sendPrivateMessage(ClientHandler sender, String recipient, String privateMessage) throws IOException {
        for (ClientHandler client : clients) {
            if (client.getUsername().equals(recipient)) {
                client.sendMessage(sender.getUsername(), privateMessage, true);
            }
        }
    }

    public synchronized void broadcastServerMessage(ClientHandler sender, String message) throws IOException {
        for (ClientHandler client : clients) {
            if (client == sender) {
                continue;
            }
            client.sendServerMessage(message);
        }
    }


}

package com.example.hendlers;


import com.example.server.MyServer;
import com.example.services.AuthenticationService;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/* в ClientHandler  сохраняется вся информация вся логика взаимоотношение с клиентом  */
public class ClientHandler {

    /* служебные сообщения */
    private static final String AUTH_CMD_PREFIX = "/auth"; // + login + password
    private static final String AUTHOK_CMD_PREFIX = "/authok"; // + username
    private static final String AUTHERR_CMD_PREFIX = "/autherr"; // + error message
    private static final String CLIENT_MSG_CMD_PREFIX = "/cMsg"; // + msg
    private static final String SERVER_MSG_CMD_PREFIX = "/sMsg"; // + msg
    private static final String PRIVATE_MSG_CMD_PREFIX = "/pm"; // + username + msg
    private static final String STOP_SERVER_CMD_PREFIX = "/stop";
    private static final String END_CLIENT_CMD_PREFIX = "/end";

    private final MyServer myServer;
    private final Socket clientSocket;
    private DataInputStream in;
    private DataOutputStream out;
    private String username;

    public ClientHandler(MyServer myServer, Socket socket) {
        this.myServer = myServer;
        clientSocket = socket;
    }


    public void handle() throws IOException {
        in = new DataInputStream(clientSocket.getInputStream());
        out = new DataOutputStream(clientSocket.getOutputStream());

        // создание потоков для каждого клиента
        new Thread(() -> {
            try {
                //процедура аутентификации клиента
                authentication();
                readMessage();
            } catch (IOException e) {
                try {
                    myServer.broadcastServerMessage(this, "Пользователь " + username + " отключился от чата");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                myServer.unSubscribe(this);
                e.printStackTrace();
            }
        }).start();
    }


    // Method с аутентификацией
    private void authentication() throws IOException {
        while (true) {

            /*

            // пример простой аутентификации

            //принимает сообщение от входящего потока (от клиента)
            String message = in.readUTF();
            System.out.println("аутентификации " + message);

            // простой пример с аутентификацией

            if(message.startsWith(AUTH_CMD_PREFIX)){
                String[]  messageParts = message.split("\\s+");
                System.out.println("LOGIN: " + messageParts[1]);
                System.out.println("PASSPORT: " + messageParts[2]);
            }
            */

            String message = in.readUTF();

            if (message.startsWith(AUTH_CMD_PREFIX)) {
                // processAuthentication(message) метод с самим процессом аутентификации
                boolean isSuccessAuth = processAuthentication(message);
                if (isSuccessAuth) {
                    break;
                } else {
                    // это отправка в консоль клиента
                    out.writeUTF(AUTHERR_CMD_PREFIX + " Неверная команда аутентификации");
                    // это отправка в консоль на сервер
                    System.out.println("Неверная команда аутентификации");
                }
            }

        }
    }


    // метод с самим процессом аутентификации
    private boolean processAuthentication(String message) throws IOException {
        // проверяет входящие сообщение, чтобы оно состояло из трех слов
        String[] parts = message.split("\\s+");
        if (parts.length != 3) {
            // это отправка в консоль клиента
            out.writeUTF(AUTHERR_CMD_PREFIX + " Неверная команда аутентификации");
            // это отправка в консоль на сервер
            System.out.println("Неверная команда аутентификации");
            return false;
        }

        String login = parts[1];
        String password = parts[2];

        AuthenticationService auth = myServer.getAuthenticationService();
        username = auth.getUsernameByLoginAndPassword(login, password);


        if (username != null) {

            // проверка на уже залогинившегося пользователя
            if (myServer.isUsernameBusy(username)) {
                out.writeUTF(AUTHERR_CMD_PREFIX + " Логин уже используется");
                return false;
            }

            // это отправка в консоль клиента
            out.writeUTF(AUTHOK_CMD_PREFIX + " " + username);
            myServer.subscribe(this);
            // это отправка в консоль на сервер
            System.out.println("Пользователь " + username + " подключился к чату");
			
			myServer.broadcastServerMessage(this, "Пользователь " + username + " подключился к чату");
			
            return true;

        } else {
            // это отправка в консоль клиента
            out.writeUTF(AUTHERR_CMD_PREFIX + " Неверная комбинация логина и пароля");
            // это отправка в консоль на сервер
            System.out.println("Неверная комбинация логина и пароля");
            return false;

        }

    }

    private void readMessage() throws IOException {
        while (true) {
            // это отправка в консоль клиента
            String message = in.readUTF();
            // это отправка в консоль на сервер
            System.out.println("message | " + username + ": " + message);

            String typeMessage = message.split("\\s+")[0];
			
			if (!typeMessage.startsWith("/")) {
                System.out.println("Неверный запрос");
            }

            switch (typeMessage) {
                case STOP_SERVER_CMD_PREFIX -> myServer.stop();
                case END_CLIENT_CMD_PREFIX -> closeConnection();
                case CLIENT_MSG_CMD_PREFIX -> {
                    String[] messageParts = message.split("\\s+", 2);
                    myServer.broadcastMessage(this, messageParts[1]);}
                case PRIVATE_MSG_CMD_PREFIX -> {
                    String[] privateMessageParts = message.split("\\s+", 3);
                    String recipient  = privateMessageParts[1];
                    String privateMessage  = privateMessageParts[2];

                    myServer.sendPrivateMessage(this, recipient, privateMessage);
                } default -> System.out.println("Неверная команда");
            }

        }
    }

    private void closeConnection() throws IOException {
        clientSocket.close();
        System.out.println(username + " отключился");
    }

    public void sendServerMessage(String message) throws IOException {
        out.writeUTF(String.format("%s %s", SERVER_MSG_CMD_PREFIX, message));
    }

    public void sendMessage(String sender, String message, Boolean isPrivate) throws IOException {
        out.writeUTF(String.format("%s %s %s", isPrivate ?
                PRIVATE_MSG_CMD_PREFIX
                : CLIENT_MSG_CMD_PREFIX,
                sender, message));
    }

    public void sendMessage(String sender, String message) throws IOException {
        sendMessage(sender, message, false);
    }

    public String getUsername() {
        return username;
    }


}

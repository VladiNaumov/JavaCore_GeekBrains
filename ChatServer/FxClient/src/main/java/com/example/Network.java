package com.example;

import javafx.application.Platform;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Network {
    private static final String AUTH_CMD_PREFIX = "/auth"; // + login + password
    private static final String AUTHOK_CMD_PREFIX = "/authok"; // + username
    private static final String AUTHERR_CMD_PREFIX = "/autherr"; // + error message
    private static final String CLIENT_MSG_CMD_PREFIX = "/cMsg"; // + msg
    private static final String SERVER_MSG_CMD_PREFIX = "/sMsg"; // + msg
    private static final String PRIVATE_MSG_CMD_PREFIX = "/pm"; // + username + msg
    private static final String STOP_SERVER_CMD_PREFIX = "/stop";
    private static final String END_CLIENT_CMD_PREFIX = "/end";
    public static final String DEFAULT_HOST = "localhost";
    public static final int DEFAULT_PORT = 8186;
    //ВНИМАНИЕ! ПЕРЕЗАГРУЗКА СЕРВЕРА ЧЕРЕЗ 15 МИНУТ
    private final String host;
    private final int port;
    private DataOutputStream out;
    private DataInputStream in;

    private ChatController chatController;
    private String username;
    private StartClientFX startClientFX;

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
            startClientFX.showErrorAlert("Ошибка подключения","Соединение не установлено");
//            start
        }
    }

    // отправка сообщение об ошибки
    public void sendMessage(String message) {
        try {
            out.writeUTF(String.format("%s %s", CLIENT_MSG_CMD_PREFIX, message));
        } catch (IOException e) {
            e.printStackTrace();
            startClientFX.showErrorAlert("Ошибка подключения","Соединение не установлено");

        }
    }

    public void sendPrivateMessage(String recipient, String message) {
        try {
            out.writeUTF(String.format("%s %s %s", PRIVATE_MSG_CMD_PREFIX, recipient, message));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ошибка при отправке сообщения");
        }
    }


    public String sendAuthMessage(String login, String password) {
        try {
            out.writeUTF(String.format("%s %s %s", AUTH_CMD_PREFIX, login, password));
            String response = in.readUTF();

            if (response.startsWith(AUTHOK_CMD_PREFIX)) {
                this.username = response.split("\\s+", 2)[1];
                return null;
            } else {
                return response.split("\\s+", 2)[1];
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ошибка при отправке сообщения");
            return e.getMessage();
        }
    }

    public void waitMessage(ChatController chatController) {
        Thread t = new Thread(() -> {
            try {
                while (true) {
                    String message = in.readUTF();

                    String typeMessage = message.split("\\s+")[0];
                    if (!typeMessage.startsWith("/")) {
                        System.out.println("Неверный запрос");
                    }

                    switch (typeMessage) {
                        case CLIENT_MSG_CMD_PREFIX -> {
                            String[] parts = message.split("\\s+", 3);
                            String sender = parts[1];
                            String messageFromSender = parts[2];

                            if (sender.equals(username)) {
                                sender = "Я";
                            }

                            String finalSender = sender;
                            Platform.runLater(() -> chatController.appendMessage(finalSender, messageFromSender));
                        }
                        case PRIVATE_MSG_CMD_PREFIX -> {
                            String[] parts = message.split("\\s+", 3);
                            String sender = parts[1];
                            String messageFromSender = parts[2];

                            Platform.runLater(() -> chatController.appendMessage("[pm]" + sender, messageFromSender));
                        }
                        case SERVER_MSG_CMD_PREFIX -> {
                            String[] parts = message.split("\\s+", 2);
                            String serverMessage = parts[1];

                            chatController.appendServerMessage(serverMessage);
                        }
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        t.setDaemon(true);
        t.start();
    }



    public String getUsername() {
        return username;
    }

    public void setStartClient(StartClientFX startClientFX) {
        this.startClientFX = startClientFX;
    }

    /*
    public StartClient getStartClient() {
        return startClient;
    }

    public DataOutputStream getOut() {
        return out;
    }

    public void setOut(DataOutputStream out) {
        this.out = out;
    }

    public DataInputStream getIn() {
        return in;
    }

    public void setIn(DataInputStream in) {
        this.in = in;
    }

     */
}

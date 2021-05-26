package com.naumDeveloper.javaCore3.unit_3.homework_server_IO;

public interface Server {
    void broadcastMessage(String message);
    void sendPrivateMessage(String from, String name, String privateMessage);
    boolean isLoggedIn(String nickname);
    void subscribe(ClientHandler client);
    void unsubscribe(ClientHandler client);
    AuthenticationService getAuthenticationService();

}

package com.naumDeveloper.WebChatServerDb.homework.server;

import homework.server.DB.DBService;
import homework.server.DB.User;

import java.util.Optional;

public class BasicAuthenticationService implements AuthenticationService{

     // ГЛАВНЫЙ ПРИ ИНИЦИАЛИЗАЦИИ КЛИЕНТОВ

    @Override
    public Optional<User> doAuth(String email, String password) {
        DBService dbService = new DBService();
        User newUser = dbService.findUser(email);

        if (newUser.getPassword().equals(password)) {
            return Optional.of(newUser);
        }

        return Optional.empty();
    }
}

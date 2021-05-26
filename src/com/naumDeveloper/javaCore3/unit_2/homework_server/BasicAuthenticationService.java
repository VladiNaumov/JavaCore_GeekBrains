package com.naumDeveloper.javaCore3.unit_2.homework_server;

import fi.lahti.unit_2.homework_server.DB.DBService;
import fi.lahti.unit_2.homework_server.DB.User;

import java.util.Optional;

public class BasicAuthenticationService implements AuthenticationService{

     // ГЛАВНЫЙ ПРИ ИНИЦИАЛИЗАЦИИ КЛИЕНТОВ


    public Optional<User> doAuth(String email, String password) {
        DBService dbService = new DBService();
        User newUser = dbService.findUser(email);

        if (newUser.getPassword().equals(password)) {
            return Optional.of(newUser);
        }

        return Optional.empty();
    }
}

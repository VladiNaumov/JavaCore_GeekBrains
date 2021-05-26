package com.naumDeveloper.javaCore3.unit_3.homework_server_IO;


import fi.lahti.unit_3.homework_server_IO.DB.DBService;
import fi.lahti.unit_3.homework_server_IO.DB.User;

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

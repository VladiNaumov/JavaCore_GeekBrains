package org.example.services;


import com.example.models.User;

import java.util.List;

public class SimpleAuthenticationServiceImpl implements AuthenticationService {

    // база пользователей сервера
    private static final List<User> clients = List.of(

            new User("martin", "1111", "Martin_Superstar"), // /auth
            new User("batman", "2222", "Брюс_Уэйн"),
            new User("gena", "3333", "Гендальф_Серый"),
            new User("mario", "4444", "Super_Mario"),
            new User("bender", "5555", "Bender"),
            new User("ezhik", "6666", "Super_Sonic")


    );


    @Override
    public String getUsernameByLoginAndPassword(String login, String password) {
        // проверяет наличие данного пользователя в базе
        for (User client : clients) {
            if (client.getLogin().equals(login) && client.getPassword().equals(password) ) {
                return client.getUsername();
            }
        }

        return null;
    }


}

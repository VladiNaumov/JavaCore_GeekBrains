package org.example.services;


/* проверяет наличие данного пользователя в базе*/
public interface AuthenticationService {
      String getUsernameByLoginAndPassword(String login, String password);
}

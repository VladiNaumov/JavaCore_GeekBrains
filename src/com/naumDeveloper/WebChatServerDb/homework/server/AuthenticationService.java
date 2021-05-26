package com.naumDeveloper.WebChatServerDb.homework.server;

import homework.server.DB.User;

import java.util.Optional;

public interface AuthenticationService {
    Optional<User> doAuth(String email, String password);
}

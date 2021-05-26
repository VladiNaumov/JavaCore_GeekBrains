package com.naumDeveloper.javaCore3.unit_3.homework_server_IO;

import fi.lahti.unit_3.homework_server_IO.DB.User;

import java.util.Optional;

public interface AuthenticationService {
    Optional<User> doAuth(String email, String password);
}

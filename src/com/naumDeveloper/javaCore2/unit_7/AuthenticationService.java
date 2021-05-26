package com.naumDeveloper.javaCore2.unit_7;



import java.util.Optional;

public interface AuthenticationService {
    Optional<User> doAuth(String login, String password);
}

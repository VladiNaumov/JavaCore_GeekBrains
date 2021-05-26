package com.naumDeveloper.javaCore3.unit_3.homework_server_IO.DB;

import java.util.ArrayList;
import java.util.List;

public interface DataBaseCommands<T> {

     T findUser(String authEmail); // НУЖЕН ПРИ ИНИЦИАЛИЗАЦИИ КЛИЕНТОВ

     int changeNickname(String oldNickName, String newNickName, String password);
}

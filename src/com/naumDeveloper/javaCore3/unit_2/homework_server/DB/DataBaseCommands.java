package com.naumDeveloper.javaCore3.unit_2.homework_server.DB;


public interface DataBaseCommands<T> {

     T findUser(String authEmail); // НУЖЕН ПРИ ИНИЦИАЛИЗАЦИИ КЛИЕНТОВ

     int changeNickname(String oldNickName, String newNickName, String password);
}

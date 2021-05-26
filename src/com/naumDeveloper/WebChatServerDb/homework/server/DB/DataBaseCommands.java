package com.naumDeveloper.WebChatServerDb.homework.server.DB;

import java.util.ArrayList;
import java.util.List;

public interface DataBaseCommands<T> {
     int initializeDataBase(ArrayList<T> users); // не влияет
     List<T> findAll(); // не влияет

     T findUser(String authEmail); // НУЖЕН ПРИ ИНИЦИАЛИЗАЦИИ КЛИЕНТОВ

     int changeNickname(String oldNickName, String newNickName, String password); // не влияет
}

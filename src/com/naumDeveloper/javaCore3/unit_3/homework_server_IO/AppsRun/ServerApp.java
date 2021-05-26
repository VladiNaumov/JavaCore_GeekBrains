package com.naumDeveloper.javaCore3.unit_3.homework_server_IO.AppsRun;

/*
    1. Создать логгер локальной истории в текстовый файл. Считываем данные введенные из консоли и добавляем в файл с новой строки.
    2. После загрузки клиента показывать ему последние 100 строк чата.
    3. * Не использовать сканер в процессе считывания данных из консоли
 */

import com.naumDeveloper.javaCore3.unit_3.homework_server_IO.ChatServer;

public class ServerApp {

    public static void main(String[] args) {
        new ChatServer();
  }

}

package com.naumDeveloper.javaCore3.unit_2.unit_Db.myDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseService {

    private DataBaseService() {}

    public static Connection getConnection(){
        // конфигурирование и подключение к БД
           try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/webserver?serverTimezone=Europe/Helsinki",
                    "admin",
                    "admin"
            );

        } catch (SQLException throwables) {
            throw new RuntimeException("SWW during establishing DB connection", throwables);
        }
    }

}

package com.naumDeveloper.javaCore3.unit_2.unit_Db.DBserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;



public class DbUserService  {

         // подключение к БД

    public Optional <User> findUserByEmailPassword(String email, String password){
        //выполнение запроса
        Connection connection = DataBaseConnection.getConnection();
        try {
            //получение данных
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM users WHERE email = ? AND password = ?"
            );
            statement.setString(1, email);
            statement.setString(2, password);

            ResultSet rs = statement.executeQuery();

            if(rs.next()){
                return Optional.of(new User(
                        rs.getString("nickname"),
                        rs.getString("email"),
                        rs.getString("password")

                )
                );

            }

            return null;


        } catch (SQLException throwables) {
            throw new RuntimeException("SWW during user all", throwables);
        }

    }


}

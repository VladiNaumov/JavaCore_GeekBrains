package com.naumDeveloper.javaCore3.unit_2.unit_Db.myDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class UserService {

    Collection<User> users;

    // чтение из БД
    public Collection<User>findAll() {

        Connection connection = DataBaseService.getConnection();

        try {

            //выполнение запроса
            Statement statement = connection.createStatement();
            //  statement.executeQuery получение данных
            ResultSet resultSet = statement.executeQuery("SELECT * FROM  users");

            users = new ArrayList<>();

            while (resultSet.next()) {
               users.add(
                        new User(
                                resultSet.getInt("id"),
                                resultSet.getString("nickname"),
                                resultSet.getString("email"),
                                resultSet.getString("password")

                        )
                );


            }
            return users;
        } catch (SQLException throwables) {
            throw new RuntimeException("SWW during user all", throwables);
        }
    }




    // запись в БД
       public int save(User user) {
        Connection connection = DataBaseService.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO users (nickname) VALUES(?)"

            );
            statement.setString(1, user.getNickname());
         //   statement.setString(2, user.getEmail());
         //   statement.setString(3, user.getPassword());

            return  statement.executeUpdate();

        } catch (SQLException throwables) {

            throw new RuntimeException("SWW during Users save", throwables);
        }

    }


}

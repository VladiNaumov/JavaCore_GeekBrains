package com.naumDeveloper.javaCore3.unit_2.homework_server.DB;

import java.sql.*;

public class DBService implements DataBaseCommands<User>{
    private boolean isChangeSuccessful;


    @Override
    public User findUser(String authEmail) {

        Connection connection = DBConnection.getConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users " +
                    "WHERE email = '" + authEmail +"';");

            if (resultSet != null) {
                User user = new User();
                while (resultSet.next()) {
                   // user.setId(resultSet.getInt("id"));
                    user.setNickname(resultSet.getString("nickname"));
                    user.setEmail(resultSet.getString("email"));
                    user.setPassword(resultSet.getString("password"));
                }
                return user;
            } else {
                System.out.println("There is no users with that email");
                return null;
            }


        } catch (SQLException e) {
            throw new RuntimeException("SWW during find user operation", e);

        } finally {
        DBConnection.close(connection);
    }

    }

    @Override
    public int changeNickname(String oldNickName, String newNickName, String password) {
        Connection connection = DBConnection.getConnection();

        try {
            boolean passCheck = false;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users " +
                    "WHERE nickname = '" + oldNickName + "';");
            while (resultSet.next()) {
                passCheck = password.equals(resultSet.getString("password"));
            }

            if (passCheck) {
                PreparedStatement changeNicknameStatement = connection.prepareStatement(
                        "UPDATE chat_users " +
                                "SET nickname = ?" +
                                "WHERE nickname = ?;"
                );
                changeNicknameStatement.setString(1, newNickName);
                changeNicknameStatement.setString(2, oldNickName);

                setChangeSuccessful(true);
                return changeNicknameStatement.executeUpdate();
            }
            setChangeSuccessful(false);
            return 0;

        } catch (SQLException e) {
            throw new RuntimeException("SWW during change nickname operation", e);

        } finally {
            DBConnection.close(connection);
        }
    }


    public boolean isChangeSuccessful() {
        return isChangeSuccessful;
    }

    public void setChangeSuccessful(boolean changeSuccessful) {
        isChangeSuccessful = changeSuccessful;
    }
}

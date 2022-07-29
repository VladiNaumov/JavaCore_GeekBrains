package com.example;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignController {

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField loginReg;

    @FXML
    private TextField passReg;

    @FXML
    private TextField usernameReg;
    private Network network;
    private StartClientFX startClientFX;


    @FXML
    void initialize() {

    }

    @FXML
    void checkAuth(ActionEvent event) {
        String login = loginField.getText().trim();
        String password = passwordField.getText().trim();

        if (login.length() == 0 || password.length() == 0) {
            System.out.println("Ошибка ввода при аутентификации");
            System.out.println();
            startClientFX.showErrorAlert("Ошибка ввода при аутентификации", "Поля не должны быть пустыми");
            return;
        }

        // ограничение длины логина и пароля
        if (login.length() > 32 || password.length() > 32) {
            startClientFX.showErrorAlert("Ошибка ввода при аутентификации", "Длина логина и пароля должны быть не более 32 символов");
            return;
        }

        // какой ответ сервера после аутентификации
        String authErrorMessage = network.sendAuthMessage(login, password);

        // проверка успешно ли прошла аутентификация или нет
        if (authErrorMessage == null) {
            //вызов самого чата
            startClientFX.openChatDialog();
        } else {
            startClientFX.showErrorAlert("Ошибка аутентификации", authErrorMessage);
        }
    }

    @FXML
    void signUp(ActionEvent event) {

    }

    public void setNetwork(Network network) {
        this.network = network;
    }

    public void setStartClient(StartClientFX startClientFX) {
        this.startClientFX = startClientFX;
    }


}

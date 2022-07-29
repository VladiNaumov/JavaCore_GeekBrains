package com.example;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class StartClientFX extends Application {

    private Network network;
    private Stage primaryStage;
    private Stage authStage;
    private ChatController chatController;
    private SignController signController;

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;

        network = new Network();
        network.setStartClient(this);
        network.connect();

        openAuthDialog();
        createChatDialog();
    }


    private void openAuthDialog() throws IOException {
        // открывает меню аутентификации
        FXMLLoader authLoader = new FXMLLoader(StartClientFX.class.getResource("auth-view.fxml"));
        authStage = new Stage();
        Scene scene = new Scene(authLoader.load(), 600, 400);
        authStage.setScene(scene);
        authStage.initModality(Modality.WINDOW_MODAL);
        authStage.initOwner(primaryStage);
        authStage.setAlwaysOnTop(true);
        authStage.show();

        signController = authLoader.getController();
        signController.setNetwork(network);
        signController.setStartClient(this);
    }


    private void createChatDialog() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StartClientFX.class.getResource("chat-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        primaryStage.setScene(scene);
        primaryStage.setAlwaysOnTop(true);

        chatController = fxmlLoader.getController();
        chatController.setNetwork(network);
        chatController.setStartClient(this);

    }

    public void openChatDialog() {
        authStage.close();
        primaryStage.show();
        primaryStage.setTitle(network.getUsername());

        network.waitMessage(chatController);
        chatController.setUsernameTitle(network.getUsername());
    }

    public void showErrorAlert(String title, String errorMessage) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(errorMessage);
        alert.show();
    }

    /*
    public void showInfoAlert(String title, String infoMessage) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(infoMessage);
        alert.show();
    }

     */

    public static void main(String[] args) {
        launch();
    }
}
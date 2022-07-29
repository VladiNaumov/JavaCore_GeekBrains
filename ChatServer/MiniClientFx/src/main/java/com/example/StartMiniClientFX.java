package com.example;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StartMiniClientFX extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StartMiniClientFX.class.getResource("chat-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.setAlwaysOnTop(true);
        stage.show();

        Network network = new Network();

        ChatController chatController = fxmlLoader.getController();
        chatController.setNetwork(network);

        network.connect();
        network.waitMessage(chatController);
    }

    public static void main(String[] args) {
        launch();
    }
}
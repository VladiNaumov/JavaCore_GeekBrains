package com.demo.controllers;

import com.demo.models.Network;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ChatController {

    private Network network;
    @FXML
    private ListView<String> usersList;

    @FXML
    private Label usernameTitle;

    @FXML
    private TextArea chatHistory;

    @FXML
    private TextField inputField;

    @FXML
    private Button sendButton;

    @FXML
    public void initialize() {

        //накидали своих собственных пользователей для отображенные их в всплывающем окне
        usersList.setItems(FXCollections.observableArrayList("Виталий", "Олег", "Андрей", "Артем"));

        sendButton.setOnAction(event -> sendMessage());
        inputField.setOnAction(event -> sendMessage());
    }

    // для отображенные сообщений в графическом окне
    private void sendMessage() {
        String message = inputField.getText().trim();
        inputField.clear();

        if (message.isEmpty()) {
            return;
        }
        //  для отображенные сообщений в графическом окне
        network.sendMessage(message);

    }

    //  для отображенные сообщений в графическом окне
    public void appendMessag(String message){
        message += System.lineSeparator();
        chatHistory.setText(new StringBuilder(chatHistory.getText()).insert(0, message).toString());

    }

    public void setNetwork(Network network) {
        this.network = network;
    }


}

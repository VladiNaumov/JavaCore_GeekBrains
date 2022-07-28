package com.example.controllers;


import com.example.models.Network;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ChatController {

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
    private Network network;

    @FXML
    public void initialize() {
        usersList.setItems(FXCollections.observableArrayList("Виталий", "Олег", "Андрей", "Артем"));

        sendButton.setOnAction(event -> sendMessage());
        inputField.setOnAction(event -> sendMessage());
    }

    private void sendMessage() {
        String message = inputField.getText().trim();
        inputField.clear();

        if (message.isEmpty()) {
            return;
        }

//        appendMessage(message);
        network.sendMessage(message);
    }

    public void appendMessage(String message) {
//        chatHistory.appendText(message);
//        chatHistory.appendText(System.lineSeparator());
        message += System.lineSeparator();
        chatHistory.setText(new StringBuilder(chatHistory.getText()).insert(0, message).toString());

    }

    public void setNetwork(Network network) {
        this.network = network;
    }
}

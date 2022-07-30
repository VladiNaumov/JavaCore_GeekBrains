package com.example;


import java.io.IOException;

public class StartMiniServer {
    public static void main(String[] args) {
        try {
            new MiniServer();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
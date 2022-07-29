package org.example;


import com.example.server.MyServer;

import java.io.IOException;

public class StartServer {

    private static final int DEFAULT_PORT = 8186;
    private static String configsFile = "src/main/resources/configs/application-dev.properties";

    public static void main(String[] args) {

        try {
            new MyServer(DEFAULT_PORT).start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /* пример подключение с помощью файла настроек */
        /*
        Properties properties = new Properties();
        try {
            properties.load(new FileReader(configsFile));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int port;
        try {
            port = Integer.parseInt(properties.getProperty("server.port"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            port = DEFAULT_PORT;
        }

        try {
            new MyServer(port).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
         */
    }


}

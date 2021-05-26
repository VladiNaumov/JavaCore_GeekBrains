package com.naumDeveloper.javaCore3.unit_3.homework_server_IO.AppsRun;

import java.io.*;
import java.net.Socket;

/**
 * Input credentials sample
 * "-auth n1@mail.com 1"
 */

public class ClientApp {
    public static void main(String[] args) {
        System.out.println("Ваш прошлый час ");
       // Masseger.printLastNLinesSecond(100);

        try {
            Socket socket = new Socket("localhost", 8888);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            new Thread(() -> {
                try {
                    while (true) {
                        String message = in.readUTF();
                        System.out.println(message);
                    }
                } catch (IOException e) {
                    throw new RuntimeException("SWW", e);
                }
            }).start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {

                try {

                    System.out.println("MSN ...");
                    String msn = reader.readLine();
                    out.writeUTF(msn);
                  //  Masseger.FileWriterMsn(msn);

                } catch (IOException e) {
                    throw new RuntimeException("SWW", e);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

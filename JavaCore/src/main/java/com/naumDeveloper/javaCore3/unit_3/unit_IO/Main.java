package com.naumDeveloper.javaCore3.unit_3.unit_IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        doSerializationDemo();
    }

    static void doSerializationDemo() {
        UserSerializator serializator = new UserSerializator();
        User u = new User();
        u.id = 10123;
        u.name = "Doggy";
        byte[] serializedUser = serializator.serialize(u);
        System.out.println(Arrays.toString(serializedUser));

        User deserializedUser = serializator.deserialize(serializedUser);
        System.out.println(deserializedUser);
    }

    static void doFileReaderDemo() {
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader(
                            new File("/PATH/TO/YOUR/log.text")
                    )
            );

//            String line;
//            while((line = br.readLine()) != null) {
//                System.out.println(line);
//            }

            br.lines().forEach(line -> {
                System.out.println(line);
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void doFileWriterDemo() {
        try {
            BufferedWriter bw = new BufferedWriter(
                    new FileWriter(
                            new File("/Users/wespe/IdeaProjects/gb-1/src/ru/geekbrains/io/log.text"),
                            true
                    )
            );

            bw.newLine();
            bw.write(
                    String.format(
                            "[Logger] %s: INFO",
                            new Date()
                    )
            );
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static void doFileInDemo() {
        try {
            FileInputStream fin = new FileInputStream(
                    new File("/Users/wespe/IdeaProjects/gb-1/src/ru/geekbrains/io/log.text")
            );

            int b;
            /**
             * Method read return unsigned byte - [0...255]
             */
            while ((b = fin.read()) != -1) {
                System.out.print((char) b);
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void doFileOutDemo() {
        try {
            FileOutputStream fout = new FileOutputStream(
                    new File("/Users/wespe/IdeaProjects/gb-1/src/ru/geekbrains/io/log.text"),
                    true
            );

            fout.write('\n');
            String logInfo = "[Logger] 01/01/2020 - 17:55:05: Logged out";
            fout.write(logInfo.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void doDataInDemo() {
        DataInputStream din = new DataInputStream(
                new ByteArrayInputStream(
                        "Hello, world!".getBytes()
                )
        );

        try {
            int b;
            /**
             * Method read return unsigned byte - [0...255]
             */
            while ((b = din.readByte()) != -1) {
                System.out.print((char) b);
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void doByteArrayDemoOut() {
        String hello = "Hello, world!";
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        try {
            bout.write(hello.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(Arrays.toString(bout.toByteArray()));
        ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
        int b;
        /**
         * Method read return unsigned byte - [0...255]
         */
        while ((b = bin.read()) != -1) {
            System.out.print((char) b);
        }
        System.out.println();
    }

    static void doByteArrayDemoIn() {
        String hello = "Hello, world!";
        ByteArrayInputStream bin = new ByteArrayInputStream(hello.getBytes());
        System.out.println(Arrays.toString(hello.getBytes()));

        int b;
        /**
         * Method read return unsigned byte - [0...255]
         */
        while ((b = bin.read()) != -1) {
            System.out.print((char) b);
        }
        System.out.println();
    }
}

package com.naumDeveloper.javaCore3.unit_3.homework_server_IO.IO;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Masseger {

    public static void FileWriterMsn(String msn) {

        try {
            BufferedWriter bw = new BufferedWriter(
                    new FileWriter(
                            new File("C:/Users/Sipmsons/Desktop/WebChatServerDb/homework_server/IO/log.txt"),
                            true
                    )
            );


            bw.write(
                    String.format(
                            " [Logger] %s: INFO " + msn,
                            new Date()
                    )
            );
            bw.newLine();
            bw.flush();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void printMsn(int count) {
        try (
                FileInputStream fin =
                        new FileInputStream(
                                "C:/Users/Sipmsons/Desktop/WebChatServerDb/homework_server/IO/log.txt"
                        );
                BufferedReader br =
                        new BufferedReader(new InputStreamReader(fin))
        ) {
            String line;
            List<String> tempLines = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                tempLines.add(line);
            }

            for (int i = count; i < tempLines.size(); i++) {
                System.out.println(tempLines.get(i));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void printLastNLinesSecond(int lines) {
        File file = new File("C:/Users/Sipmsons/Desktop/WebChatServerDb/homework_server/IO/log.txt");

        try {
            RandomAccessFile raf = new RandomAccessFile(file, "r");
            long fileLength = file.length()-1;
            StringBuilder sb = new StringBuilder();
            int reachedLines = -1;

            raf.seek(fileLength);

            for (long ptr = fileLength; ptr >= 0 ; ptr--) {
                raf.seek(ptr);
                char c = (char) raf.read();

                if (c == '\n') {
                    reachedLines++;

                    if (reachedLines == lines) {
                        break;
                    }
                }

                sb.append(c);
            }

            sb.reverse();

            System.out.println(sb.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

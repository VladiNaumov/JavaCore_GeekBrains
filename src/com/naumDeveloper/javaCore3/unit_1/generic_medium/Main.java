package com.naumDeveloper.javaCore3.unit_1.generic_medium;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        MarkupDocument<File> xml = new XmlDocument("UTF-8");
        System.out.println(xml.getHeader());
        System.out.println(xml.getContent());

        MarkupDocument<String> html = new HtmDocument("UTF-16");
        System.out.println(html.getHeader());
        System.out.println(html.getContent());

        Document<String> test = new HtmDocument("UTF - 256");
        System.out.println(test.getHeader());
        System.out.println(test.getContent());


    }
}

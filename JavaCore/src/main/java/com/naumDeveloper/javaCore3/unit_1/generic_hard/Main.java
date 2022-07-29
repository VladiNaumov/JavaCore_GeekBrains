package com.naumDeveloper.javaCore3.unit_1.generic_hard;


import com.naumDeveloper.javaCore3.unit_1.generic_hard.document.HtmlDocument;
import com.naumDeveloper.javaCore3.unit_1.generic_hard.document.MarkupDocument;
import com.naumDeveloper.javaCore3.unit_1.generic_hard.document.HtmlDom;

public class Main {
    public static void main(String[] args) {
        MarkupDocument<HtmlDom, String> doc = new HtmlDocument("UTF-8");
        doc.setContent("<h1>Hello, world!</h1>");
        doc.appendSequence("<p>Hi!</p>");
        doc.appendSequence("<p>Bye!</p>");
        System.out.println(doc.getContent());
    }
}

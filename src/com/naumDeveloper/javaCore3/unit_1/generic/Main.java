package com.naumDeveloper.javaCore3.unit_1.generic;

import com.naumDeveloper.javaCore3.unit_1.generic.document.BinaryDocument;
import com.naumDeveloper.javaCore3.unit_1.generic.document.HtmlDocument;
import com.naumDeveloper.javaCore3.unit_1.generic.document.PdfBinaryDocument;
import com.naumDeveloper.javaCore3.unit_1.generic.document.PdfDocument;

import java.io.File;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
          PdfDocument pdfDocument = new PdfDocument();
          File pdf = pdfDocument.getContent();
          System.out.println(pdf);

        PdfBinaryDocument pdfBinaryDocument = new PdfBinaryDocument();
        int pdfBinary = pdfBinaryDocument.getContent();
        System.out.println(pdfBinary);

        BinaryDocument binaryDocument = new BinaryDocument();
        byte[] binary = binaryDocument.getContent();
        System.out.println(binary);

        HtmlDocument htmlDocument = new HtmlDocument();
        String s = htmlDocument.getContent();
        System.out.println(s);

        int[] numerot = new int[10];
        ArrayList arrayList = new ArrayList();
    }
}

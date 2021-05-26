package com.naumDeveloper.javaCore3.unit_1.generic_medium;

public abstract class MarkupDocument<T> implements Document<T>{

    protected String encoding;

    public MarkupDocument(String encoding) {
        this.encoding = encoding;
    }

}

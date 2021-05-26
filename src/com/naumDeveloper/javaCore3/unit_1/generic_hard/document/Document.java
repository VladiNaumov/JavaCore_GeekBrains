package com.naumDeveloper.javaCore3.unit_1.generic_hard.document;

public interface Document<T> {
     T getContent();
     void setContent(T content);
     void append(T element);
}

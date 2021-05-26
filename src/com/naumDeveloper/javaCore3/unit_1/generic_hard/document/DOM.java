package com.naumDeveloper.javaCore3.unit_1.generic_hard.document;

public abstract class DOM {
    private String content;

    public DOM(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

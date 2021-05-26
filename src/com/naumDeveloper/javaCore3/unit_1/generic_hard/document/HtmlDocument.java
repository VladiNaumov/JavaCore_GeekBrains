package com.naumDeveloper.javaCore3.unit_1.generic_hard.document;

public class HtmlDocument extends MarkupDocument<HtmlDom, String> {
    public HtmlDocument(String encoding) {
        super(new HtmlDom("", ""), encoding);
    }

    @Override
    public String getContent() {
        return structure.getContent();
    }

    @Override
    public void setContent(String content) {
        structure.setContent(content);
    }
}

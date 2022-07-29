package com.naumDeveloper.javaCore3.unit_1.generic_hard.document;

//

public abstract class MarkupDocument<S extends DOM, T> implements Document<T> {
    protected S structure;
    protected String encoding;

    public MarkupDocument(S structure, String encoding) {
        this.structure = structure;
        this.encoding = encoding;
    }

    @Override
    public void append(T element) {
        StringBuilder sb = new StringBuilder(structure.getContent());
        sb.append(element);
        structure.setContent(sb.toString());
    }

    public <SEQ extends CharSequence> void appendSequence(SEQ sequence) {
        StringBuilder sb  = new StringBuilder(structure.getContent());
        sb.append(sequence);
        structure.setContent(sb.toString());
    }
}

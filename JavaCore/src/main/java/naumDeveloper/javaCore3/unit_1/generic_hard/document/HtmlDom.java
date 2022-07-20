package naumDeveloper.javaCore3.unit_1.generic_hard.document;

public class HtmlDom extends DOM {
    private String header;

    public HtmlDom(String content, String header) {
        super(content);
        this.header = header;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }
}

package naumDeveloper.javaCore3.unit_1.generic_medium;

public class HtmDocument extends MarkupDocument<String>{

    public HtmDocument(String encoding) {
        super(encoding);
    }

    @Override
    public String getHeader() {
        return "Im HTML Document";
    }

    @Override
    public String getContent() {
        return "Hello Word";
    }


}

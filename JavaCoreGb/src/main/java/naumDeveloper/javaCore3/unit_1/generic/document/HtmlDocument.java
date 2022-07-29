package naumDeveloper.javaCore3.unit_1.generic.document;

public class HtmlDocument implements IDocument<String>{


    @Override
    public String getHeader() {
        return "HtmlDocument -> Hello Word ";
    }

    @Override
    public String getContent() {
        return "HtmlDocument -> Hello Word ";
    }
}

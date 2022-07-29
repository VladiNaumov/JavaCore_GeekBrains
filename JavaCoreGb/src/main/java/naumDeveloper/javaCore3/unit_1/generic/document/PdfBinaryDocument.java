package naumDeveloper.javaCore3.unit_1.generic.document;

public class PdfBinaryDocument implements IDocument<Integer> {


    @Override
    public Integer getHeader() {
        return 1;
    }

    @Override
    public Integer getContent() {
        return 2;
    }
}

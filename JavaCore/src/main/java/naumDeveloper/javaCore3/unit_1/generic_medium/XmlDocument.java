package naumDeveloper.javaCore3.unit_1.generic_medium;

import java.io.File;

public class XmlDocument extends MarkupDocument<File>{

    public XmlDocument(String encoding) {
        super(encoding);
    }


    @Override
    public File getHeader() {
        return null;
    }

    @Override
    public File getContent() {
        return null;
    }
}

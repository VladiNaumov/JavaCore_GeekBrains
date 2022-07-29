package naumDeveloper.javaCore3.unit_3.unit_IO;

import java.io.Serializable;

public class User implements Serializable {
    int id;
    String name;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

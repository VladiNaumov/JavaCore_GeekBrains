package com.naumDeveloper.javaCore3.unit_3.unit_IO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class UserSerializator {
    public byte[] serialize(User user) {
        try (ByteArrayOutputStream bout = new ByteArrayOutputStream();
             ObjectOutputStream oout = new ObjectOutputStream(bout)) {

            oout.writeObject(user);

            return bout.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException("SWW", e);
        }
    }

    public User deserialize(byte[] bytes) {
        try {
            ByteArrayInputStream bin = new ByteArrayInputStream(bytes);
            ObjectInputStream oin = new ObjectInputStream(bin);
            return (User) oin.readObject();
        } catch (Exception e) {
            throw new RuntimeException("SWW", e);
        }
    }
}

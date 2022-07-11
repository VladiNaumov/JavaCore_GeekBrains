package com.naumDeveloper.more.object_counter;

import java.util.ArrayList;


/*
счетчик objectov
 */
public class Main {
    public static void main(String[] args) {

        ArrayList<User> book = new ArrayList<>();
        book.add(new User("VoVa"));
        book.add(new User());
        book.add(new User("DIMA"));
        book.add(new User());
        book.add(new User());
        book.add(new User());
        book.add(new User());
        book.add(new User("SERGAY"));


        for (User p: book  ) {
            System.out.println(p);
        }

    }
}
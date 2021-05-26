package com.naumDeveloper.javaCore3.unit_2.unit_Db.myDB;



//1:39:46

public class Main {

    public static void main(String[] args) {

    UserService userService = new UserService();
   // User user = new User(4, "VoVa");
   // userService.save(user);

    System.out.println(userService.findAll());


    }
}

package com.naumDeveloper.javaCore3.unit_2.unit_Db.myDB.DBserver;


public class Main {
    public static void main(String[] args) {

      DbUserService db = new DbUserService();
      db.findUserByEmailPassword("n1@mail.com", "1");


    }
}

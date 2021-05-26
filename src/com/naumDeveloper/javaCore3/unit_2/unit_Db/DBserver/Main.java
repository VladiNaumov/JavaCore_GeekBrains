package com.naumDeveloper.javaCore3.unit_2.unit_Db.DBserver;


import com.naumDeveloper.javaCore3.unit_2.unit_Db.DBserver.DbUserService;

public class Main {
    public static void main(String[] args) {

      DbUserService db = new DbUserService();
      System.out.println(db.findUserByEmailPassword("n1@mail.com", "1"));


    }
}

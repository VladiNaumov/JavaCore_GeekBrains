package naumDeveloper.javaCore2.unit_3.book;

import java.util.*;

public class TelephonBook {

    private Map<String, Set<String>> myBook= new HashMap<>();

    public void add(String nimi, String numerot) {
        if(myBook.containsKey(nimi)){
            myBook.get(nimi).add(numerot);
        }else{
            Set<String>numbers=new HashSet<>();
            numbers.add(numerot);
            myBook.put(nimi, numbers);
        }

   }


   public Set<String> get(String name){

       System.out.println("****  Haetaan myBook: " + name);
        if(myBook.get(name) == null){
            return new HashSet<>();
        }

       return myBook.get(name);

   }
 }

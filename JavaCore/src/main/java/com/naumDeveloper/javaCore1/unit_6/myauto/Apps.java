package com.naumDeveloper.javaCore1.unit_6.myauto;


import com.naumDeveloper.javaCore1.unit_6.myauto.auto.Audi;
import com.naumDeveloper.javaCore1.unit_6.myauto.auto.Kia;
import com.naumDeveloper.javaCore1.unit_6.myauto.auto.Lexus;
import com.naumDeveloper.javaCore1.unit_6.myauto.audisystem.AudioSystem;
import com.naumDeveloper.javaCore1.unit_6.myauto.audisystem.Kenwood;
import com.naumDeveloper.javaCore1.unit_6.myauto.audisystem.Pioneer;
import com.naumDeveloper.javaCore1.unit_6.myauto.audisystem.Sony;
import com.naumDeveloper.javaCore1.unit_6.myauto.auto.Porhe;
import com.naumDeveloper.javaCore1.unit_6.myauto.gps.NavigationSystem;
import com.naumDeveloper.javaCore1.unit_6.myauto.gps.Navitel;


public class Apps {

   public static void main(String[] args) {


        System.out.println("******** первый способ ***********");

        Audi car = new Audi(new Sony(), new Navitel());
        car.move();
        car.getNavigationSystem().createRoute();
        car.getAudioSystem().playRadio();

        System.out.println("******** второй способ ***********");
        Lexus audi = new Lexus();
        audi.setAudioSystem(new Kenwood());
        audi.setNavigationSystem(new Navitel());

        audi.move();
        audi.getNavigationSystem().createRoute();
        audi.getAudioSystem().playCD();

        System.out.println("******** третий способ ***********");

        Pioneer pioneer = new Pioneer();
        Navitel navitel = new Navitel();
        Kia kia = new Kia(pioneer,navitel );
        kia.move();
        kia.getAudioSystem().playRadio();
        kia.getNavigationSystem().createRoute();


       System.out.println("******** четвёртый способ ***********");

       NavigationSystem navigationSystem = new Navitel();
       AudioSystem audioSystem = new Pioneer();
       navigationSystem.createRoute();
       audioSystem.playCD();

       Porhe porhe = new Porhe(audioSystem,navigationSystem);
       porhe.move();
       porhe.getNavigationSystem().createRoute();
       porhe.getAudioSystem().playRadio();

       

    }
}

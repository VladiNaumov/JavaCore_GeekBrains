package com.naumDeveloper.javaCore3.unit_5.homework;

public class Track extends Transport {

    public Track(String name, float size, float consuption, float capasityF, FuelStaion fuelStaion) {
        super(name, size, consuption, capasityF, fuelStaion);
    }


    public void trackDrive(){
        try {

            while (capasity > 0) {
                Thread.sleep(1000);
                capasity -= consuption;
                System.out.println("MSD -> " + name + " топливо в баке ... "  + capasity);

            }
            float doRefuel = fuelStaion.fuelStantionDoRefuel((size - capasity));
            capasity = doRefuel;

            if (doRefuel != 0F) {
                System.out.println("Заправились, едим дальше " + name);
                trackDrive();
            }else{
                System.out.println("Топливо кончалось " + name);
                return;
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        trackDrive();


    }
}

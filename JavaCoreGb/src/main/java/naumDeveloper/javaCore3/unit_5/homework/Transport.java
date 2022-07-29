package naumDeveloper.javaCore3.unit_5.homework;

public abstract class Transport implements Runnable{

    protected String name;

    // это объем бака
    protected float size;

    // расход топливо
    protected float consuption;

    //F - фактическое состояние бака
    protected float capasity;

    protected FuelStaion fuelStaion;


    public Transport(String name, float size, float consuption, float capasity, FuelStaion fuelStaion) {
        this.name = name;
        this.size = size;
        this.consuption = consuption;
        this.capasity = capasity;
        this.fuelStaion = fuelStaion;
    }
}

package naumDeveloper.javaCore1.unit_6.myauto.audisystem;

public class Kenwood implements AudioSystem {


    @Override
    public void playCD() {
        System.out.println("Music from Kenwood CD");
    }

    @Override
    public void playRadio() {
        System.out.println("Radio from Kenwood Radio");
    }
}

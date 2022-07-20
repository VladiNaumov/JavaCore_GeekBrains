package naumDeveloper.javaCore1.unit_6.myauto.audisystem;

public class Sony implements AudioSystem {


    @Override
    public void playCD() {
        System.out.println("Music from Sony CD");
    }

    @Override
    public void playRadio() {
        System.out.println("Radio from Sony Radio");
    }
}

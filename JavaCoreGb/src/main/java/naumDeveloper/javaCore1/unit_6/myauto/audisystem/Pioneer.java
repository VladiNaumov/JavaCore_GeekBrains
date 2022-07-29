package naumDeveloper.javaCore1.unit_6.myauto.audisystem;

public class Pioneer implements AudioSystem {


    @Override
    public void playCD() {
        System.out.println("Music from Pioneer CD");
    }

    @Override
    public void playRadio() {
        System.out.println("Radio from Pioneer Radio");
    }
}

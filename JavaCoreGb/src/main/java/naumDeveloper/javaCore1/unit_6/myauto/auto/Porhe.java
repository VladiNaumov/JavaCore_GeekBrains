package naumDeveloper.javaCore1.unit_6.myauto.auto;


import naumDeveloper.javaCore1.unit_6.myauto.audisystem.AudioSystem;
import naumDeveloper.javaCore1.unit_6.myauto.gps.NavigationSystem;


public class Porhe  implements Car{

    private AudioSystem audioSystem;
    private NavigationSystem navigationSystem;

    public AudioSystem getAudioSystem() {
        return audioSystem;
    }


    public NavigationSystem getNavigationSystem() {
        return navigationSystem;
    }

    public Porhe(AudioSystem audioSystem, NavigationSystem navigationSystem) {
        this.audioSystem = audioSystem;
        this.navigationSystem = navigationSystem;
    }

    @Override
    public void move() {
        System.out.println("Поднять пaруса!");
    }

    @Override
    public void test() {
        //test abstract method
    }
}

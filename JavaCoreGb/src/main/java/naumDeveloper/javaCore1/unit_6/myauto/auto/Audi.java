package naumDeveloper.javaCore1.unit_6.myauto.auto;


import naumDeveloper.javaCore1.unit_6.myauto.audisystem.AudioSystem;
import naumDeveloper.javaCore1.unit_6.myauto.gps.NavigationSystem;


public class Audi implements Car {

    private AudioSystem audioSystem;
    private NavigationSystem navigationSystem;



    public Audi(AudioSystem audioSystem, NavigationSystem navigationSystem) {
        this.audioSystem = audioSystem;
        this.navigationSystem = navigationSystem;
    }

    public Audi() {

    }


    @Override
    public void move() {
            System.out.println("Поднять пaруса!");
    }

    @Override
    public void test() {
        //test abstract method
    }

    public void init(){
        System.out.println("Composing your new car...");
    }

    public AudioSystem getAudioSystem() {

        return audioSystem;
    }

    public void setAudioSystem(AudioSystem audioSystem) {
        this.audioSystem = audioSystem;
    }

    public NavigationSystem getNavigationSystem() {
        return navigationSystem;
    }

    public void setNavigationSystem(NavigationSystem navigationSystem) {
        this.navigationSystem = navigationSystem;
    }


}

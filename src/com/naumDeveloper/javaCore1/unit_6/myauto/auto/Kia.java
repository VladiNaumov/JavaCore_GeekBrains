package com.naumDeveloper.javaCore1.unit_6.myauto.auto;


import com.naumDeveloper.javaCore1.unit_6.myauto.audisystem.AudioSystem;
import com.naumDeveloper.javaCore1.unit_6.myauto.gps.NavigationSystem;


public class Kia implements Car {

    private AudioSystem audioSystem;
    private NavigationSystem navigationSystem;

    public Kia() {
    }

    public Kia(AudioSystem audioSystem, NavigationSystem navigationSystem) {
        this.audioSystem = audioSystem;
        this.navigationSystem = navigationSystem;
    }

    public NavigationSystem getNavigationSystem() {
        return navigationSystem;
    }
    public AudioSystem getAudioSystem() {

        return audioSystem;
    }

    @Override
    public void move() {
        System.out.println("Поднять пaруса!");
    }

    @Override
    public void test() {

    }
}

package com.naumDeveloper.callback;

public class MyButton {
    private String text;
    private  Action action;

    public MyButton(String text) {
        this.text = text;
    }

    public void setAction(Action action){
        this.action = action;
    }

    public void click(){
        action.doIt();
    }
}

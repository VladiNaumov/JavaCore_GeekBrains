package com.naumDeveloper.callback;

public class CallbackDemo {

    public static void main(String[] args) {

        MyButton button = new MyButton("DEL");
        button.setAction(()-> System.out.println(1));
        button.click();

        /*----*/
        MyButton button1 = new MyButton("MOVE");
        button1.setAction(new Action() {
            @Override
            public void doIt() {
                System.out.println(2);
            }
        });
        button1.click();

        /*----*/
        MyButton button2 = new MyButton("START");
        button2.setAction(new Action() {
            @Override
            public void doIt() {
                System.out.println(3);
            }
        });
        button2.click();

    }
}

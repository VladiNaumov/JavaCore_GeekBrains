package com.naumDeveloper.javaCore3;



public class Main {

    public static void main(String[] args) {

            System.out.println(makeCoffeeCup( 3));
            System.out.println(makeCoffeeCup( -1));

        }

        public static String makeCoffeeCup (int type) {

            String coffee = null;
            switch (type) {
                case 1: {
                    coffee = "Espresso";
                }
                case 2: {
                    coffee = "Americano";
                }
                case 3: {
                    coffee = "Latte";
                }
                default: {
                    coffee = "Unknown";
                }
            }
            return coffee;
        }
    }



package ru.job4j.ood.ocp;

import java.util.List;

public class Birds {
    public void fly() {
        System.out.println("...");
    }

    public static class Sparrow extends Birds {

        public void fly() {
            System.out.println("chirp chirp");
        }
    }

    public static class Crow extends Birds {

        public void fly() {
            System.out.println("Kar kar");
        }
    }

    /*
     * Расширили за счет наследования,
     * но класс Birds спроектирован неверно,
     * так как пингвин - не умеет летать,
     *  нужно делать изначально с помощью интерфейса
     * */
    public static class Penguin extends Birds {

        public void fly() {
            System.out.println("Penguin does not fly");
        }
    }

    public static void main(String[] args) {
        List<Birds> guns = List.of(new Sparrow(), new Crow(), new Penguin());
        guns.forEach(Birds::fly);
    }
}

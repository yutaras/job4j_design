package ru.job4j.ood.dip;

public class ExampleWrong {
    /**
     * Данный пример нарушает принцип DIP тем,
     * что класс Sparrow полностью зависит от класса Bird.
     * Решение: нужно использовать прослойку между зависимостей в виде интерфейса.
     */

    class Bird {
        void fly() {
            System.out.println("Fly");
        }
    }

    class Sparrow {
        Bird sparrow = new Bird();
        void sparrowFly() {
            sparrow.fly();
        }
    }
}

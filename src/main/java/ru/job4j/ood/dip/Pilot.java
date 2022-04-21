package ru.job4j.ood.dip;

/**
 * Метод controlAirbus() нарушает принцип DIP тем,
 * что принимает конкретный класс, вместо абстрактного.
 */

public class Pilot {
    public void controlAirbus(Airbus airbus) {
        airbus.control();
    }
}

class Airbus {
    public void control() {
        System.out.println("Control Airbus");
    }
}


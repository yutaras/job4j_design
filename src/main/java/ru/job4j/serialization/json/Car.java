package ru.job4j.serialization.json;

import java.util.Arrays;

public class Car {
    private final boolean truck;
    private final int power;
    private final Number number;
    private final String name;
    private final String[] statuses;

    public Car(boolean truck, int power, Number number, String name, String[] statuses) {
        this.truck = truck;
        this.power = power;
        this.number = number;
        this.name = name;
        this.statuses = statuses;
    }

    @Override
    public String toString() {
        return "Car{"
                + "truck=" + truck
                + ", power=" + power
                + ", number=" + number
                + ", name=" + name
                + ", statuses=" + Arrays.toString(statuses)
                + '}';
    }
}


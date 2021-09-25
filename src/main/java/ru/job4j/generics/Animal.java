package ru.job4j.generics;

import java.util.Date;

public class Animal {
    private String name;
    private String type;

    public Animal(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Animal{"
                + "name='" + name + '\''
                + ", type='" + type + '\'' + '}';
    }
}

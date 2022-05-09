package ru.job4j;

public class PizzaExtraCheese extends Pizza {
    public String name() {
        return super.name() + " + extra cheese";
    }
}

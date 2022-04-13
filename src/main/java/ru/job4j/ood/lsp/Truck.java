package ru.job4j.ood.lsp;

public class Truck implements Vehicles {
    private static  int size;

    public Truck(int size) {
        if (size < 2) {
            throw new IllegalArgumentException("Size of truck must be greater then 1!");
        }
    }

    @Override
    public int getSize() {
        return size;
    }
}

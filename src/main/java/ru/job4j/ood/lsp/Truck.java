package ru.job4j.ood.lsp;

public class Truck implements Vehicles {
    private final int size;

    public Truck(int size) {
        if (size < 2) {
            throw new IllegalArgumentException("Size of truck must be greater then 1!");
        }
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }
}

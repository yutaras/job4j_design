package ru.job4j.ood.isp;

/**
 * Здесь методы заправки надо реализовать отдельными интерфейсами.
 * Иначе при реализации приедется глушить какой-то из них
 */
public interface Car {
    void move();

    void refueledGas();

    void refueledGasoline();
}

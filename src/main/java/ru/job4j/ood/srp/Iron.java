package ru.job4j.ood.srp;
/**
 * Интерфейс Утюг представляет собой абстрактный утюг с функциями:
 * глажения и связи по wi-fi для передачи данных в умный дом.
 * интерфейс имеет различный функционал, нарушается принцип SRP
 */
public interface Iron {

    void iron();

    void wifiConnection();

}
package ru.job4j.ood.srp;

import java.util.List;

/**
 * Класс представляет собой реализацию интерфейса Доставка в Москве.
 * Реализация имеет различный функционал, нарушается принцип SRP
 */
class DeliveryMoscow implements Delivery {
    @Override
    public List<String> groceryList(List<String> names) {
        return null;
    }

    @Override
    public void cook(List<String> products) {

    }
}

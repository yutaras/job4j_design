package ru.job4j.ood.srp;

import java.util.List;

/**
 * Интерфейс Доставка представляет собой абстрактную доставку с самостоятельным приготовлением пищи.
 */
public interface Delivery {

    List<String> groceryList(List<String> names);

    void cook(List<String> products);
}

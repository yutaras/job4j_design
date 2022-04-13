package ru.job4j.ood.lsp;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public interface Storage {
    boolean add(Food food);

    boolean accept(Food food);

    List<Food> getListSt();

    default int getPercent(Food food) {
        LocalDate dateNow = LocalDate.now();
        Period currentPeriod = Period.between(dateNow, food.createDate);
        Period storageLife = Period.between(food.expiryDate, food.createDate);
        return currentPeriod.getDays() * 100 / storageLife.getDays();
    }
}

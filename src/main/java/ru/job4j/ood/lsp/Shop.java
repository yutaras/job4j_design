package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Storage {

    List<Food> listS = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        boolean rsl = accept(food);
        if (rsl) {
            if (getPercent(food) > 75) {
                food.setPrice(food.getPrice() - food.getPrice() * food.getDiscount());
            }

            listS.add(food);
        }
        return rsl;
    }

    @Override
    public boolean accept(Food food) {
        return getPercent(food) >= 25 && getPercent(food) < 100;
    }

    @Override
    public List<Food> getListSt() {
        return List.copyOf(listS);
    }

    @Override
    public void cleared() {
        listS.clear();
    }
}

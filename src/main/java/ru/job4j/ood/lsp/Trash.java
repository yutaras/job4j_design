package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Storage {
    List<Food> listT = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        boolean rsl = false;
        if (accept(food)) {
            listT.add(food);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public boolean accept(Food food) {
        return getPercent(food) >= 100;
    }

    @Override
    public List<Food> getListSt() {
        return List.copyOf(listT);
    }
}

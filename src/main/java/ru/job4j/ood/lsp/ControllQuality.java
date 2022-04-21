package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;

public class ControllQuality {
    List<Storage> listStorage;

    public ControllQuality(List<Storage> listStorage) {
        this.listStorage = listStorage;
    }

    public void assign(Food food) {
        for (Storage storage : listStorage) {
            if (storage.accept(food)) {
                storage.add(food);
            }
        }
    }

    public void resort() {
        List<Food> products = new ArrayList<>();
        for (Storage storage : listStorage) {
            products.addAll(storage.getListSt());
            storage.cleared();
        }
        for (Food food : products) {
            assign(food);
        }
    }
}

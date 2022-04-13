package ru.job4j.ood.lsp;

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
}

package ru.job4j.ood.dip;

import java.util.ArrayList;
import java.util.List;

/**
 *  Нарушение принципа DIP: в поле класса находися конкретная реализация List<String>,
 *  что не даст нам возможности изменить реализацию класса
 *  */


public class Fridge {

    private List<String> products = new ArrayList<>();

    public Fridge(List<String> products) {
        this.products = products;
    }
}

package ru.job4j.ood.lsp;

import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class ControllQualityTest {

    @Test
    public void whenTrash() {
        Storage trash = new Trash();
        Storage shop = new Shop();
        Storage warehouse = new Warehouse();
        ControllQuality controllQuality = new ControllQuality(List.of(trash, shop, warehouse));
        Food bread = new Food("bread", LocalDate.now(),
                LocalDate.now().minusDays(2), 55, 0.25);
        controllQuality.assign(bread);
        assertThat(trash.getListSt(), is(List.of(bread)));
    }

    @Test
    public void whenWarehouse() {
        Storage trash = new Trash();
        Storage shop = new Shop();
        Storage warehouse = new Warehouse();
        ControllQuality controllQuality = new ControllQuality(List.of(trash, shop, warehouse));
        Food milk = new Food("milk", LocalDate.now().plusDays(15),
                LocalDate.now().minusDays(1), 55, 0.25);
        controllQuality.assign(milk);
        assertThat(warehouse.getListSt(), is(List.of(milk)));
    }

    @Test
    public void whenShop() {
        Storage trash = new Trash();
        Storage shop = new Shop();
        Storage warehouse = new Warehouse();
        ControllQuality controllQuality = new ControllQuality(List.of(trash, shop, warehouse));
        Food milk = new Food("milk", LocalDate.now().plusDays(10),
                LocalDate.now().minusDays(10), 55, 0.25);
        controllQuality.assign(milk);
        assertThat(shop.getListSt(), is(List.of(milk)));
        assertThat(milk.price, is(55.0));
    }

    @Test
    public void whenShopDiscount() {
        Storage trash = new Trash();
        Storage shop = new Shop();
        Storage warehouse = new Warehouse();
        ControllQuality controllQuality = new ControllQuality(List.of(trash, shop, warehouse));
        Food milk = new Food("milk", LocalDate.now().plusDays(2),
                LocalDate.now().minusDays(10), 55, 0.25);
        controllQuality.assign(milk);
        assertThat(shop.getListSt(), is(List.of(milk)));
        assertThat(milk.price, is(41.25));
    }
}
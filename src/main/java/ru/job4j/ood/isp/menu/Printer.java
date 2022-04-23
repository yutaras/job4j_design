package ru.job4j.ood.isp.menu;

import java.util.Collections;

public class Printer implements MenuPrinter {
    private static final String STR = "--";

    @Override
    public void print(Menu menu) {
        for (Menu.MenuItemInfo info : menu) {
            String str = STR + info.getNumber() + info.getName();
            int length = info.getNumber().length();
            str = str.replace(STR, String.join("", Collections.nCopies(length, STR)));
            System.out.println(str);
        }
    }
}

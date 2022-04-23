package ru.job4j.ood.isp.menu;

import java.util.Scanner;

public class TODOApp {
    public static final ActionDelegate STUB_ACTION = System.out::println;
    private static final int ADD = 0;
    private static final int SELECT = 1;
    private static final int OUTPUT_ALL = 2;
    private static final int EXIT = 3;

    public void init(Scanner scanner) {
        Menu menu = new SimpleMenu();
        boolean run = true;
        while (run) {
            showMenu();
            System.out.print("Select: ");
            int select = Integer.parseInt(scanner.nextLine());
            if (select == ADD) {
                System.out.println("Enter name parent");
                String parent = scanner.next();
                System.out.println("Enter child name");
                String child = scanner.next();
                menu.add(parent, child, STUB_ACTION);
            } else if (select == SELECT) {
                System.out.println("Enter child name");
                String child = scanner.next();
                System.out.println(menu.select(child));
            } else if (select == OUTPUT_ALL) {
                System.out.println("Output All");
                Printer printer = new Printer();
                printer.print(menu);
            } else if (select == EXIT) {
                run = false;
            }
        }
    }

    private void showMenu() {
        String[] menu = {"Add", "Select", "Output All", "Exit"};
        System.out.println("Menu:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + ". " + menu[i]);
        }
    }
}

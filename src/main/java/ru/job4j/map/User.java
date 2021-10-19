package ru.job4j.map;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class User {

    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        Calendar calendar = new GregorianCalendar(2021, Calendar.OCTOBER, 19);
        User user1 = new User("Ivan", 2, calendar);
        User user2 = new User("Ivan", 2, calendar);
        Map<User, Object> map = new HashMap<>();
        map.put(user1, new Object());
        map.put(user2, new Object());
        for (User key : map.keySet()) {
            Object value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}

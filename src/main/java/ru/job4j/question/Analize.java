package ru.job4j.question;

import java.util.HashMap;
import java.util.Set;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        int added = 0, deleted = 0, changed = 0;
        HashMap<Integer, String> map1 = new HashMap<>();
        HashMap<Integer, String> map2 = new HashMap<>();
        for (User cur : current) {
            map1.put(cur.getId(), cur.getName());
        }
        for (User prev : previous) {
            if (map1.put(prev.getId(), prev.getName()) == null) {
                deleted++;
            }
        }
        for (User prev : previous) {
            map2.put(prev.getId(), prev.getName());
        }
        for (User cur : current) {
            if (!map2.containsKey(cur.getId())) {
                added++;
            }
            if (map2.containsKey(cur.getId()) && (!map2.containsValue(cur.getName()))) {
                changed++;
            }
        }
        return new Info(added, changed, deleted);
    }
}
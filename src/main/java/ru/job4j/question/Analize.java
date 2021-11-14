package ru.job4j.question;

import java.util.HashMap;
import java.util.Set;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        int added = 0, changed = 0, deleted;
        HashMap<Integer, String> map = new HashMap<>();
        for (User prev : previous) {
            map.put(prev.getId(), prev.getName());
        }
        for (User cur : current) {
            if (!map.containsKey(cur.getId())) {
                added++;
            }
            if (map.containsKey(cur.getId()) && (!map.containsValue(cur.getName()))) {
                changed++;
            }
        }
        deleted = previous.size() + added - current.size();
        return new Info(added, changed, deleted);
    }
}
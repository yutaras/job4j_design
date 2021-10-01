package ru.job4j.generics;

import java.util.HashMap;
import java.util.Map;

public final class MemStore<T extends Base> implements Store<T> {

    private final Map<String, T> mem = new HashMap<>();

    @Override
    public void add(T model) {
        if (!mem.containsKey(model.getId())) {
            mem.put(model.getId(), model);
        }
    }

    @Override
    public boolean replace(String id, T model) {
        if (findById(id) != null) {
            mem.put(id, model);
        }
        return true;
    }

    @Override
    public boolean delete(String id) {
        if (findById(id) != null) {
            mem.remove(id);
        }
        return true;
    }

    @Override
    public T findById(String id) {
        T rsl = null;
        for (String user : mem.keySet()) {
            if (user.equals(id)) {
                rsl = mem.get(id);
                break;
            }
        }
        return rsl;
    }
}
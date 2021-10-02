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
        boolean rsl = false;
        if (findById(id) != null) {
            mem.put(id, model);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public boolean delete(String id) {
        boolean rsl = false;
        if (findById(id) != null) {
            mem.remove(id);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public T findById(String id) {
        return mem.get(id);
    }
}
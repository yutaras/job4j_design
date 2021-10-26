package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];


    @Override
    public boolean put(K key, V value) {
        if (count >= LOAD_FACTOR * capacity) {
            expand();
        }
        int index = (key == null) ? 0 : indexFor(hash(key.hashCode()));
        boolean rsl = table[index] == null;
        if (rsl) {
            table[index] = new MapEntry<>(key, value);
            count++;
            modCount++;
        }
        return rsl;
    }

    private int hash(int hashCode) {
        return hashCode % capacity;
    }

    private int indexFor(int hash) {
        return hash & (table.length - 1);
    }

    private void expand() {
        MapEntry<K, V>[] temp = table;
        capacity = capacity * 2;
        table = new MapEntry[capacity];
        for (MapEntry<K, V> map : temp) {
            if (map != null) {
                this.put(map.key, map.value);
            }
        }
    }

    @Override
    public V get(K key) {
        int index = (key == null) ? 0 : indexFor(hash(key.hashCode()));
        return table[index] == null ? null : table[index].value;
    }

    @Override
    public boolean remove(K key) {
        int index = (key == null) ? 0 : indexFor(hash(key.hashCode()));
        boolean rsl = table[index] != null;
        if (rsl) {
            table[index] = null;
            count--;
            modCount++;
        }
        return rsl;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            final int expectedModCount = modCount;
            int position;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (position < table.length - 1 && table[position] == null) {
                    position++;
                }
                return table[position] != null;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[position++].key;
            }
        };
    }

    private static class MapEntry<K, V> {

        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}

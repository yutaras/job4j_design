package ru.job4j.collection;

import java.util.*;

public class SimpleArrayList<T> implements List<T> {

    private T[] container;

    private int size = 0;

    private int modCount = 0;

    public SimpleArrayList(int capacity) {
        this.container = (T[]) new Object[capacity];
    }

    public void increaseSize(int size) {
        if (size == container.length) {
            container = Arrays.copyOf(container, container.length * 2);
        }
    }

    @Override
    public void add(T value) {
        increaseSize(size);
        container[size++] = value;
        modCount++;
    }

    @Override
    public T set(int index, T newValue) {
        for (int i = 0; i < size; i++) {
            Objects.checkIndex(index, container.length);
        }
        T temp = container[index];
        container[index] = newValue;
        return temp;
    }

    @Override
    public T remove(int index) {
        for (int i = 0; i < size; i++) {
            Objects.checkIndex(index, container.length);
        }
        T temp = container[index];
        System.arraycopy(container, index + 1,
                container, index, container.length - index - 1);
        container[container.length - 1] = null;
        size--;
        modCount++;
        return temp;
    }

    @Override
    public T get(int index) {
        for (int i = 0; i < size; i++) {
            Objects.checkIndex(index, container.length);
        }
        return container[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            int index = 0;
            final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return container[index++];
            }
        };
    }
}

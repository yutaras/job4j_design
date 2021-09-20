package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {

    private int[] data;
    private int index;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        if (data.length == index) {
            return false;
        }
        if (data.length == 1 || index == data.length - 1) {
            return data[index] % 2 == 0;
        } else {
            while (data[index] % 2 != 0 && index < data.length - 1) {
                index++;
            }
            return true;
        }
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[index++];
    }
}

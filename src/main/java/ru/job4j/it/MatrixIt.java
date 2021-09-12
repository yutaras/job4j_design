package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        int count = 0;
        for (int[] datum : data) {
            for (int element : datum) {
                count += element;
            }
        }
        if ((data.length != 1) && (count != 0)) {
            while (data[row].length == 0) {
                row++;
            }
        }
        return column < data[row].length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Integer r = data[row][column++];
        if (column >= data[row].length) {
            row++;
            column = 0;
        }
        return r;
    }
}
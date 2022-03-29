package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return maxValue(value, comparator);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return maxValue(value, comparator.reversed());
    }

    public <T> T maxValue(List<T> value, Comparator<T> comparator) {
        T maxVal = value.get(0);
        for (T val : value) {
            if (comparator.compare(val, maxVal) > 0) {
                maxVal = val;
            }
        }
        return maxVal;
    }
}
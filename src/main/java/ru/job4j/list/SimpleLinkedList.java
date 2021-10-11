package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements List<E> {

    private int size = 0;
    private Node<E> first;
    private Node<E> last;
    private int modCount = 0;

    @Override
    public void add(E value) {
        final Node<E> l = last;
        last = new Node<>(value, null);
        if (l == null) {
            first = last;
        } else {
            l.nextNode = last;
        }
        size++;
        modCount++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> target = first;
        for (int i = 0; i < index; i++) {
            target = target.nextNode;
        }
        return target.element;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private final int expectedModCount = modCount;
            private Node<E> current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                } else {
                    E data = current.element;
                    current = current.nextNode;
                    return data;
                }
            }
        };
    }

    private static class Node<E> {
        private  E element;
        private Node<E> nextNode;

        Node(E element, Node<E> nextNode) {
            this.element = element;
            this.nextNode = nextNode;
        }

    }
}

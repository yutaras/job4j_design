package ru.job4j.map;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleMapTest {

    @Test
    public void whenPut() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(1, "Федя");
        map.put(3, "Иван");
        assertThat(map.get(1), is("Федя"));
        assertThat(map.get(3), is("Иван"));
    }

    @Test
    public void whenGet() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(1, "Федя");
        map.put(3, "Иван");
        assertThat(map.get(1), is("Федя"));
        assertThat(map.get(3), is("Иван"));
    }

    @Test
    public void whenExpand() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(1, "Федя");
        map.put(2, "Иван");
        map.put(3, "Саша");
        map.put(4, "Николай");
        map.put(5, "Женя");
        map.put(6, "Юра");
        map.put(7, "Анатолий");
        map.put(8, "Вениамин");
        map.put(9, "Алла");
        map.put(10, "Дмитрий");
        assertThat(map.get(1), is("Федя"));
        assertThat(map.get(10), is("Дмитрий"));
    }

    @Test
    public void whenRemove() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(1, "Федя");
        map.put(3, "Иван");
        map.remove(3);
        assertThat(map.get(1), is("Федя"));
        assertNull(map.get(3));
    }

    @Test
    public void whenRemoveEmpty() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        assertFalse(map.remove(1));
    }

    @Test
    public void whenIterator() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(1, "Федя");
        map.put(3, "Иван");
        Iterator<Integer> it = map.iterator();
        assertTrue(it.hasNext());
        assertThat(it.next(), is(1));
        assertTrue(it.hasNext());
        assertThat(it.next(), is(3));
        assertFalse(it.hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void whenNextFromEmpty() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        Iterator<Integer> it = map.iterator();
        it.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenConcurrentModificationException() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        Iterator<Integer> it = map.iterator();
        map.put(1, "Федя");
        it.next();
    }
}
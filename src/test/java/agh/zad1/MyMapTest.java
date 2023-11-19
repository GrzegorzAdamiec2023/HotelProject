package agh.zad1;

import agh.zad1.MyMap.MyMap;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyMapTest {

    @Test
    public void put() {
        MyMap<String, String> map = new MyMap();
        map.put("Jan", "Kowalski");
        assertEquals("Kowalski", map.get("Jan"));
    }

    @Test
    public void get() {
        MyMap<String, String> map = new MyMap();
        map.put("Jan", "Kowalski");
        assertEquals("Kowalski", map.get("Jan"));
    }

    @Test
    public void keys() {
        MyMap<String, String> map = new MyMap();
        map.put("Jan", "Kowalski");
        map.put("Marta", "Nowak");
        assertEquals(2,  map.keys().size());
    }

    @Test
    public void remove() {
        MyMap<String, String> map = new MyMap();
        map.put("Jan", "Kowalski");
        map.put("Marta", "Nowak");
        map.remove("Marta");
        assertEquals(1, map.keys().size());
    }

    @Test
    public void clear() {
        MyMap<String, String> map = new MyMap();
        map.put("Jan", "Kowalski");
        map.put("Marta", "Nowak");
        map.clear();
        assertEquals(0, map.keys().size());
    }
}
package agh.zad1.MyMap;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyMap<K, V>{

    private final List<K> keys;
    private final List<V> values;

    public MyMap() {
        keys = new ArrayList<>();
        values = new LinkedList<>();
    }


    public void put(K key, V value) {
        int index = keys.indexOf(key);
        if (index != -1) {

            values.set(index, value);
        } else {

            keys.add(key);
            values.add(value);
        }
    }


    public V get(K key) {
        int index = keys.indexOf(key);
        return index != -1 ? values.get(index) : null;
    }


    public List<K> keys() {
        return new ArrayList<>(keys);
    }


    public void remove(K key) {
        int index = keys.indexOf(key);
        if (index != -1) {
            keys.remove(index);
            values.remove(index);
        }
    }


    public void clear() {
        keys.clear();
        values.clear();
    }

}
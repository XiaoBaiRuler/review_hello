package hash;


import javafx.util.Pair;

import java.util.*;

/**
 * @Author xiaobai
 * @Date 2021/1/22 18:32
 * @Version 1.0
 */
public class MyHashMap {
    private final int MAX_LEN = 100000;
    private List<Pair<Integer, Integer>>[] map;

    public MyHashMap() {
        map = (List<Pair<Integer, Integer>>[]) new LinkedList[MAX_LEN];
    }

    private int getIndex(int key){
        return key - key / 101 * 101;
    }

    public void put(int key, int value){
        int index = getIndex(key);
        LinkedList<Pair<Integer,Integer>> item = (LinkedList<Pair<Integer, Integer>>) map[index];
        Pair<Integer, Integer> newItem = new Pair<>(key, value);
        if (item == null){
            LinkedList<Pair<Integer, Integer>> newList = new LinkedList<>();
            newList.add(newItem);
            map[index] = newList;
        }
        else{
            int i = 0;
            for (; i < item.size(); i++) {
                Pair<Integer, Integer> p = item.get(i);
                if (p.key == key){
                    p.setValue(value);
                    item.set(i, p);
                    break;
                }
            }
            if (i == item.size()){
                item.add(newItem);
            }
        }
    }

    public int get(int key){
        LinkedList<Pair<Integer, Integer>> item = (LinkedList<Pair<Integer, Integer>>) map[getIndex(key)];
        if (item == null){
            return -1;
        }
        for (int i = 0; i < item.size(); i++) {
            Pair<Integer, Integer> p = item.get(i);
            if (p.key == key){
                return p.value;
            }
        }
        return -1;
    }

    public void remove(int key){
        LinkedList<Pair<Integer, Integer>> item = (LinkedList<Pair<Integer, Integer>>) map[getIndex(key)];
        if (item != null){
            item.removeIf(pair -> pair.key == key);
        }
    }

    class Pair<K,V>{

        public void setKey(K key) {
            this.key = key;
        }

        public void setValue(V value) {
            this.value = value;
        }

        private K key;

        public K getKey() { return key; }

        private V value;

        public V getValue() { return value; }

        public Pair(K key,V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return Objects.equals(key, pair.key) && Objects.equals(value, pair.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }
    }
}

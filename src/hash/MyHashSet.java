package hash;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author xiaobai
 * @Date 2021/1/21 16:48
 * @Version 1.0
 */
public class MyHashSet {

    private static final int DEFAULT_SIZE = 10000;
    private static final int DEFAULT_MOD = 101;
    private List[] theLists;

    /** Initialize your data structure here. */
    public MyHashSet() {
        theLists = new LinkedList[DEFAULT_SIZE];
        for (int i = 0; i < theLists.length; i++) {
            theLists[i] = new LinkedList<Integer>();
        }
    }

    public void add(int key) {
        LinkedList<Integer> whichList = (LinkedList<Integer>) theLists[myHash(key)];
        if (!whichList.contains(key)){
            whichList.add(key);
        }
    }

    public void remove(int key) {
        LinkedList<Integer> whichList = (LinkedList<Integer>) theLists[myHash(key)];
        if (whichList.contains(key)){
            whichList.remove((Integer) key);
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        LinkedList<Integer> whichList = (LinkedList<Integer>) theLists[myHash(key)];
        return whichList.contains(key);
    }

    private int myHash(int x){
        return x - x / DEFAULT_MOD * DEFAULT_MOD;
    }
}

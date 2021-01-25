package hash;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author xiaobai
 * @Date 2021/1/20 22:03
 * @Version 1.0
 */
public class MyHashTable<AnyType> {
    private static final int DEFAULT_TABLE_SIZE = 101;
    private LinkedList[] theList;
    private int currentSize;

    public MyHashTable() {
    }

    public MyHashTable(int size) {
        theList = new LinkedList[nextPrime(size)];
        for (int i = 0; i < theList.length; i++) {
            theList[i] = new LinkedList<>();
        }
    }

    private int nextPrime(int n) {
        return n;
    }
    
    public void makeEmpty(){
        for (int i = 0; i < theList.length; i++) {
            theList[i].clear();
        }
        currentSize = 0;
    }
    
    public boolean contains(AnyType x){
        LinkedList<AnyType> whichList = theList[myHash(x)];
        return whichList.contains(x);
    }

    private int myHash(AnyType x) {
        int hashValue = x.hashCode();
        hashValue = hashValue - (hashValue / theList.length) * theList.length;
        if (hashValue < 0){
            hashValue += theList.length;
        }
        return hashValue;
    }

    public void insert(AnyType x){
        List<AnyType> whichList = theList[myHash(x)];
        if (!whichList.contains(x)){
            whichList.add(x);
            if (++currentSize > theList.length){
                rehash();
            }
        }
    }

    private void rehash() {
        List<AnyType>[] oldList = theList;

        theList = new LinkedList[nextPrime(2 * theList.length)];
        for (int i = 0; i < theList.length; i++) {
            theList[i] = new LinkedList<>();
        }
        currentSize = 0;
        for (int i = 0; i < oldList.length; i++) {
            for (AnyType item : oldList[i]){
                insert(item);
            }
        }
    }

    public void remove(AnyType x){
        List<AnyType> whichList = theList[myHash(x)];
        if (whichList.contains(x)){
            whichList.remove(x);
            currentSize --;
        }
    }
    
}

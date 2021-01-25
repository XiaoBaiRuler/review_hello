package hash;

import java.util.HashMap;

/**
 * @Author xiaobai
 * @Date 2021/1/19 23:07
 * @Version 1.0
 */
public class TestHash {
    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        System.out.println(hashMap.get(1));
        System.out.println(hashMap.get(3));
        hashMap.put(2, 1);
        System.out.println(hashMap.get(2));
        hashMap.remove(2);
        System.out.println(hashMap.get(2));
    }
}

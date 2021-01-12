package table;

import java.util.*;

/**
 * @Author xiaobai
 * @Date 2021/1/6 22:01
 * @Version 1.0
 */
public class Table_01 {
    public static void main(String[] args) {
//        int[] arr = new int[10];
//
//        int[] newArr = new int[arr.length * 2];
//        for (int i = 0; i < arr.length; i++) {
//            newArr[i] = arr[i];
//        }
//        arr = newArr;
//        System.out.println(Arrays.toString(arr));

        LinkedList<Integer> linkedList = new LinkedList<>();
        int i = 1;
        while (i < 10){
            linkedList.add(i);
            i ++;
        }
        ListIterator<Integer> listIterator = linkedList.listIterator();
        while (listIterator.hasNext()){
            int a = listIterator.next();
            if (a % 2 == 0){
                listIterator.set(0);
            }
        }
        System.out.println(linkedList);
    }

    public static void removeEvensVer1(List<Integer> lst){
        int i = 0;
        while (i < lst.size()){
            if (lst.get(i) % 2 == 0){
                lst.remove(i);
            }
            else{
                i ++;
                i ++;
            }
        }
    }
}

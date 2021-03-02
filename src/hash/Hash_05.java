package hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author xiaobai
 * @Date 2021/3/2 9:29
 * @Version 1.0
 */
public class Hash_05 {
    public static void main(String[] args) {
        String[] list1 = {"Shogun","Tapioca Express","Burger King","KFC"};
        String[] list2 = {"KFC","Burger King","Tapioca Express","Shogun"};
        System.out.println(Arrays.toString(findRestaurant(list1, list2)));
    }

    /**
     * 多余操作太多，接近N^2了
     * @param list1 list1
     * @param list2 list2
     * @return String[]
     */
    public static String[] findRestaurant(String[] list1, String[] list2) {
        HashSet<String> hashSet = new HashSet<>(16);
        ArrayList<String> arrayList = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        int item = 0;
        boolean flag = true;
        while (i < list1.length && flag){
            if (!hashSet.contains(list1[i])){
                hashSet.add(list1[i]);
            }
            while (j < list2.length){
                if (hashSet.contains(list2[j])){
                    item = i + j;
                    if (item == min){
                        arrayList.add(list2[j]);
                        hashSet.remove(list2[j]);
                    }
                    else if (item < min){
                        if (arrayList.size() == 0){
                            min = item;
                            arrayList.add(list2[j]);
                            hashSet.remove(list2[j]);
                        }
                        else{
                            min = item;
                            arrayList.clear();
                            arrayList.add(list2[j]);
                            hashSet.remove(list2[j]);
                        }
                    }
                    else{
                        flag = false;
                        break;
                    }
                }
                j ++;
            }
            i ++;
            j = 0;
        }

        return arrayList.toArray(new String[arrayList.size()]);
    }

    public static String[] findRestaurantChange(String[] list1, String[] list2){
        HashMap<String , Integer> map = new HashMap<>(16);
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < list2.length && i <= min; i++) {
            if (map.containsKey(list2[i])){
                sum = i + map.get(list2[i]);
                if (sum < min){
                    arrayList.clear();
                    arrayList.add(list2[i]);
                    min = sum;
                }
                else if (sum == min){
                    arrayList.add(list2[i]);
                }
            }
        }
        return arrayList.toArray(new String[arrayList.size()]);
    }
}

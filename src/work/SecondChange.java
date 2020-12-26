package work;

import java.util.*;

/**
 * @Author xiaobai
 * @Date 2020/12/14 22:21
 * @Version 1.0
 */
public class SecondChange {

    public static void main(String[] args) {
        String[] strs = {""};
        HashMap<String, ArrayList<String>> hashMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars2 = strs[i].toCharArray();
            Arrays.sort(chars2);
            String key = String.valueOf(chars2);
            ArrayList<String> item = new ArrayList<>();
            if (hashMap.containsKey(key)) {
                item = (ArrayList<String>) hashMap.get(key).clone();
                item.add(strs[i]);
                hashMap.put(key, item);
            }else{
                item.add(strs[i]);
                hashMap.put(key, item);
            }
        }
        ArrayList<List<String>> all = new ArrayList<>();
        for (ArrayList<String> value : hashMap.values()) {
            all.add(value);
        }
        System.out.println(all);
    }
}

package string;

import java.util.HashMap;

/**
 * @Author xiaobai
 * @Date 2020/12/20 12:05
 * @Version 1.0
 */
public class String_03 {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("lloo"));

    }
    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char item;
        for (int i = 0; i < s.length(); i++) {
            item = s.charAt(i);
            if (map.containsKey(item)){
                map.put(item, map.get(item) + 1);
            }
            else{
                map.put(item, 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            item = s.charAt(i);
            if (map.get(item) == 1){
                return i;
            }
        }
        return -1;
    }
}

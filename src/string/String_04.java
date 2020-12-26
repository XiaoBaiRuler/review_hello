package string;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author xiaobai
 * @Date 2020/12/20 12:21
 * @Version 1.0
 */
public class String_04 {
    public static void main(String[] args) {
        String s = "ebad";
        String t = "bbcd";
        System.out.println(isAnagram(s, t));
    }
    public static boolean isAnagram(String s, String t) {

        int allS = s.codePointCount(0, s.length());
        int allT = t.codePointCount(0, t.length());

        if (allS != allT){
            return false;
        }
        else{
            int[] cs = s.codePoints().toArray();
            int[] ct = t.codePoints().toArray();
            bubbleSort(cs);
            bubbleSort(ct);
            for (int i = 0; i < allS; i++) {
                if (cs[i] != ct[i]){
                    return false;
                }
            }
        }
        return true;
    }

    public static void bubbleSort(int[] c){
        int all = c.length;
        int item = 0;
        for (int i = 0; i < all - 1; i++) {
            for (int j = 0; j < all - i - 1; j++) {
                if (c[j] > c[j + 1]){
                    item = c[j + 1];
                    c[j + 1] = c[j];
                    c[j] = item;
                }
            }
        }
    }
}

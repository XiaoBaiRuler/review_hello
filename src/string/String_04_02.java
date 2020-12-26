package string;

/**
 * 哈希表具体
 *
 * @Author xiaobai
 * @Date 2020/12/21 10:15
 * @Version 1.0
 */
public class String_04_02 {
    public static void main(String[] args) {
        String s = "abcd";
        String t = "efgh";
        System.out.println(isAnagram(s, t));
    }
    public static boolean isAnagram(String s, String t) {
        int allS = s.length();
        int allT = t.length();
        if (allS != allT){
            return false;
        }
        int[] num = new int[26];
        for (int i = 0; i < allS; i++) {
            num[s.charAt(i) - 'a'] ++;
            num[t.charAt(i) - 'a'] --;
        }
        for (int i = 0; i < num.length; i++) {
            if (num[i] < 0){
                return false;
            }
        }
        return true;
    }
}

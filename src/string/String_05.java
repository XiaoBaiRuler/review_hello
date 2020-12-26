package string;

import java.util.regex.Pattern;

/**
 * @Author xiaobai
 * @Date 2020/12/20 12:24
 * @Version 1.0
 */
public class String_05 {
    public static void main(String[] args) {
        //正读和反读相等: 可以尝试双指针
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }
    public static boolean isPalindrome(String s) {
        int all = s.length();
        String pattern = "[A-Za-z0-9]";
        StringBuilder sb = new StringBuilder();
        char c;
        for (int i = 0; i < all; i++) {
            c = s.charAt(i);
            if (Pattern.matches(pattern, c + "")){
                sb.append(c);
            }
        }
        String str = sb.toString().toLowerCase();
        System.out.println(str);
        int strAll = str.length();
        int stop = strAll / 2;
        for (int i = 0; i < stop; i++) {
            if (str.charAt(i) != str.charAt(strAll - 1 - i)){
                return false;
            }
        }
        return true;
    }
}

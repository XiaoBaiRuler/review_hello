package string;

import java.util.Arrays;

/**
 * @Author xiaobai
 * @Date 2020/12/20 11:39
 * @Version 1.0
 */
public class String_02 {
    public static void main(String[] args) {
        System.out.println(reverse(-1999999999));
    }
    public static int reverse(int x) {
        String str = new String(Integer.toString(x));
        boolean flag = false;
        String line = "-";
        if (str.startsWith(line)){
            str = str.substring(1);
            flag = true;
        }

        char[] chars = str.toCharArray();
        int all = chars.length;
        int stop = all / 2;
        char item;
        for (int i = 0; i < stop; i++) {
            item = chars[i];
            chars[i] = chars[all - i - 1];
            chars[all - i - 1] = item;
        }
        StringBuilder sb = new StringBuilder();
        for (char aChar : chars) {
            sb.append(aChar);
        }
        long l = 0;
        if (flag){
            l = -Long.parseLong(sb.toString());
            if (l < Integer.MIN_VALUE){
                return 0;
            }
        }
        else{
            l = Long.parseLong(sb.toString());
            if (l > Integer.MAX_VALUE){
                return 0;
            }
        }
        return (int)l;
    }
}

package string;

/**
 * @Author xiaobai
 * @Date 2020/12/18 9:51
 * @Version 1.0
 */
public class String_01 {
    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
        System.out.println(s);
    }
    public static void reverseString(char[] s) {
        //双指针，前后扫描数组
        int all = s.length;
        int stop = all / 2;
        char item;
        for (int i = 0; i < stop; i++) {
            item = s[i];
            s[i] = s[all - i - 1];
            s[all - i - 1] = item;
        }
    }
}

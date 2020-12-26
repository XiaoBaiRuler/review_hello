package string;

/**
 * @Author xiaobai
 * @Date 2020/12/22 10:51
 * @Version 1.0
 */
public class String_09 {
    public static void main(String[] args) {
        String[] strs = {""};
        System.out.println(longestCommonPrefix(strs));
    }
    public static String longestCommonPrefix(String[] strs) {
        int all1 = strs.length;
        if (all1 == 0){
            return "";
        }
        String flag = strs[0];
        int all2 = flag.length();
        for (int i = 1; i < all1; i++) {
            if (!strs[i].startsWith(flag)){
                all2 --;
                flag = flag.substring(0, all2);
                i = 0;
            }
        }

        return flag;
    }
}

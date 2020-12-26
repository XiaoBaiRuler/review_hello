package string;

/**
 * @Author xiaobai
 * @Date 2020/12/22 10:50
 * @Version 1.0
 */
public class String_08 {
    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }
    public static String countAndSay(int n) {
        int i = 0;
        String old = "1";
        while (i < n - 1){
            old = count(old);
            i ++;
        }

        return old;

    }
    public static String count(String old){
        int all = old.length();
        StringBuilder sb = new StringBuilder();
        String flag = String.valueOf(old.charAt(0));
        String item = "";
        int c = 0;
        for (int i = 0; i < all; i++) {
            item = String.valueOf(old.charAt(i));
            if (item.equals(flag)){
                c ++;
            }
            else{
                sb.append(c);
                sb.append(flag);
                flag = item;
                c = 1;
            }
        }
        sb.append(c);
        sb.append(flag);
        return sb.toString();
    }
}

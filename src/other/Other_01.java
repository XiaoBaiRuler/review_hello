package other;

/**
 * @Author xiaobai
 * @Date 2021/1/28 12:36
 * @Version 1.0
 */
public class Other_01 {

    public static void main(String[] args) {
        System.out.println(hammingWeight(10));
    }
    public static int hammingWeight(int n) {
        String s = Integer.toBinaryString(n);
        int count = 0;
        int all = s.length();
        for (int i = 0; i < all; i++) {
            if (s.charAt(i) == '1'){
                count ++;
            }
        }
        return count;
    }
}

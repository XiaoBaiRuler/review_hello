package other;

/**
 * @Author xiaobai
 * @Date 2021/1/28 12:58
 * @Version 1.0
 */
public class Other_02 {
    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
    }
    public static int hammingDistance(int x, int y) {
        String s = Integer.toBinaryString((x ^ y));
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

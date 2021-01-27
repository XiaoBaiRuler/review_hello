package math;

/**
 * @Author xiaobai
 * @Date 2021/1/27 22:00
 * @Version 1.0
 */
public class Math_01 {
    public static void main(String[] args) {
        System.out.println(isPowerOfThree(243));
    }

    /**
     * 整数限制
     * @param n int
     * @return boolean
     */
    public static boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}

package math;

/**
 * @Author xiaobai
 * @Date 2021/1/27 22:48
 * @Version 1.0
 */
public class Math_02 {
    public static void main(String[] args) {
        System.out.println(countPrimes(499979));
    }
    public static int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isSu(i)){
                count ++;
            }
        }
        return count;
    }

    private static boolean isSu(int i) {
        if (i <= 3){
            return i > 1;
        }

        // 不在6的倍数两侧的一定不是质数
        if (i % 6 != 1 && i % 6 != 5){
            return false;
        }
        int sqrt = (int) Math.sqrt(i);
        for (int j = 5; j <= sqrt; j += 6) {
            if (i % j == 0 || i % (j + 2) == 0){
                return false;
            }
        }
        return true;
    }
}

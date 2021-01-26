package dynamic;

/**
 * @Author xiaobai
 * @Date 2021/1/26 22:48
 * @Version 1.0
 */
public class Dynamic_01 {
    public static void main(String[] args) {
//        System.out.println(climbStairs(4));
        System.out.println(climbStairsChange(4));
    }

    /**
     * 虽然是动态规划，但是不知道什么是动态规划？？？是分解问题？？
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 超时了
     * @param n n
     * @return int
     */
    public static int climbStairsChange(int n){
        if (n == 0 || n == 1){
            return 1;
        }
        else{
            return climbStairsChange(n - 1) + climbStairsChange(n - 2);
        }
    }

    /**
     * 动态规划 + 滚动数组思想
     * @param n n
     * @return int
     */
    public static int climb(int n){
        int a = 0;
        int b = 0;
        int c = 1;
        for (int i = 1; i <= n ; i++) {
            a = b;
            b = c;
            c = a + b;
        }
        return c;
    }
}

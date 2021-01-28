package dynamic;

/**
 * @Author xiaobai
 * @Date 2021/1/27 18:10
 * @Version 1.0
 */
public class Dynamic_04 {
    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 7, 5, 3, 1};
        System.out.println(rob(nums));
    }
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length + 1];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length ; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }

    public static int robChange(int[] nums){
        if (nums == null || nums.length == 0){
            return 0;
        }
        int a = nums[0];
        if (nums.length == 1){
            return a;
        }
        int b = Math.max(nums[0], nums[1]);
        if (nums.length == 2){
            return b;
        }
        int temp = 0;
        for (int i = 2; i < nums.length; i++) {
            temp = Math.max(a + nums[i], b);
            a = b;
            b = temp;
        }
        return temp;
    }
}
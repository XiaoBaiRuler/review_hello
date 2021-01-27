package dynamic;

/**
 * @Author xiaobai
 * @Date 2021/1/27 18:07
 * @Version 1.0
 */
public class Dynamic_03 {
    public static void main(String[] args) {

    }

    /**
     * 动态规划
     * @param nums int[]
     * @return int
     */
    public static int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum > 0){
                sum += nums[i];
            }
            else{
                sum = nums[i];
            }
            res = Math.max(res, sum);
        }
        return res;
    }
}

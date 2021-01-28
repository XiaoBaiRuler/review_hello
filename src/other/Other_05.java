package other;

/**
 * @Author xiaobai
 * @Date 2021/1/28 17:52
 * @Version 1.0
 */
public class Other_05 {
    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
        System.out.println(missingNumber(nums));
    }
    public static int missingNumber(int[] nums) {
        int all = nums.length;
        int max = (all * (all + 1)) / 2;
        for (int i = 0; i < all; i++) {
            max -= nums[i];
        }
        return max;
    }
}

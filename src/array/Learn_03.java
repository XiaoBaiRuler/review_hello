package array;

/**
 * @Author xiaobai
 * @Date 2020/12/16 19:54
 * @Version 1.0
 */
public class Learn_03 {

    public static void main(String[] args) {
        int[] nums = {-1, -100, 3, 99};
        rotate(nums, 2);
    }

    public static void rotate(int[] nums, int k) {
        int item = 0;
        int total = nums.length;
        for (int i = 0; i < k; i++) {
            item = nums[total - 1];
            System.arraycopy(nums, 0, nums, 1, total - 1);
            nums[0] = item;
        }
    }
}

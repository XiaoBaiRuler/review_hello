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
        int all = nums.length;
        if (all == 0){
            return 0;
        }
        return -1;
    }
}

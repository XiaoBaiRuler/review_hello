package array;

import java.util.Arrays;

/**
 * @Author xiaobai
 * @Date 2020/12/17 20:16
 * @Version 1.0
 */
public class Learn_08 {
    public static void main(String[] args) {
        int[] nums = {1,0,0,0,1};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void moveZeroes(int[] nums) {

        int all = nums.length;
        for (int i = 0; i < all; i++) {
            if (nums[i] == 0){
                delI(nums, i, all);
                i --;
                all --;
            }
        }
    }
    public static void delI(int[] nums, int i, int all){
        for (int j = i; j < all - 1; j++) {
            nums[j] = nums[j + 1];
        }
        nums[all - 1] = 0;
    }
}

package desgin;

import java.util.Random;

/**
 * @Author xiaobai
 * @Date 2021/1/28 11:03
 * @Version 1.0
 */
public class Solution {

    private int[] nums;
    private int[] original;
    private Random r = new Random();


    public Solution(int[] nums) {
        this.nums = nums;
        this.original = nums.clone();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        nums = original;
        original = original.clone();
        return original;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int i = 0; i < nums.length; i++) {
            swap(i, randRange(i, nums.length));
        }
        return nums;
    }

    private int randRange(int min, int max){
        return r.nextInt(max - min) + min;
    }

    private void swap(int i, int j){
        int item = nums[i];
        nums[i] = nums[j];
        nums[j] = item;
    }
}

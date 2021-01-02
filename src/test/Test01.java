package test;

import java.util.Arrays;

/**
 * @Author xiaobai
 * @Date 2020/12/31 22:02
 * @Version 1.0
 */
public class Test01 {
    public static void main(String[] args) {
        int[] nums = new int[10000000];
        for (int i = 0; i < 10000000; i++) {
            nums[i] = i + 1;
        }
        long start = System.currentTimeMillis();
        //16
        System.out.println(findMaximumBySelect(nums));
        //16
        System.out.println(findMaximumByBubbleSort(nums));
        long stop = System.currentTimeMillis();
        System.out.println(stop - start);
    }

    /**
     * 通过冒泡排序的交换方式获取最大值: 其实第一次交换就可以获得最大值
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     * @param nums
     * @return
     */
    public static int findMaximumByBubbleSort(int[] nums){
        int all = nums.length;
        for (int i = 1; i < all; i++) {
            if (nums[i] > nums[0]){
                int item = nums[0];
                nums[0] = nums[i];
                nums[i] = item;
            }
        }
        return nums[0];
    }

    /**
     * 直接和每个数据判断，比某个其他数据大，就替换，直到最后返回
     * @param nums nums
     * @return int
     */
    public static int findMaximumBySelect(int[] nums){
        int all = nums.length;
        int max = nums[0];
        for (int i = 1; i < all; i++) {
            if (nums[i] > nums[0]){
                max = nums[i];
            }
        }
        return max;
    }


}

package array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author xiaobai
 * @Date 2020/12/17 7:59
 * @Version 1.0
 */
public class Learn_06 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,8,2,4,5};
        int[] nums2 = {2,3,4,5,1,8};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }

    /**
     * 模仿筛子
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        if (n1 >= n2) {
            return sieveImprove(nums1, nums2, n1, n2);
        }
        else{
            return sieveImprove(nums2, nums1, n2, n1);
        }
    }




    public static void bubbleSort(int[] nums){
        int item = 0;
        //冒泡排序
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]){
                    item = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = item;
                }
            }
        }
    }

    public static void delI(int[] nums, int i){
        int all = nums.length;
        for (int j = i; j < all - 1; j++) {
            nums[j] = nums[j + 1];
        }
    }

    public static int[] sieveImprove(int[] maxNums, int[] minNums, int max, int min){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            for (int k = 0; k < min; k++) {
                if (minNums[k] != Integer.MAX_VALUE){
                    if (maxNums[i] == minNums[k]){
                        list.add(minNums[k]);
                        minNums[k] = Integer.MAX_VALUE;
                        break;
                    }
                }
            }
        }
        int j = 0;
        int[] result = new int[list.size()];
        for (Integer i : list){
            result[j] = i;
            j ++;
        }
        return result;
    }
}

package sort;

import java.util.Arrays;

/**
 * @Author xiaobai
 * @Date 2021/1/13 22:58
 * @Version 1.0
 */
public class Sort_01 {
    public static void main(String[] args) {
        int[] nums1 = {6, 18, 19, 0, 0, 0, 0};
        int[] nums2 = {8, 9, 19, 20};
        merge(nums1, 3, nums2, 4);
        System.out.println(Arrays.toString(nums1));
    }

    /**
     * 使用检测突变来吧
     * @param nums1 nums1
     * @param m m
     * @param nums2 nums2
     * @param n n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int j = 0; j < n; j++) {
            for (int i = j; i < m; i++) {
                if (nums1[i] > nums2[j]) {
                    int item = nums2[j];
                    nums2[j] = nums1[i];
                    nums1[i] = item;
                }
            }
        }
        for (int k = 0; k < n; k++) {
            nums1[m + k] = nums2[k];
        }
    }
}

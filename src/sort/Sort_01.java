package sort;

import java.util.Arrays;

/**
 * @Author xiaobai
 * @Date 2021/1/13 22:58
 * @Version 1.0
 */
public class Sort_01 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {4, 5, 6};
        mergeChange(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

    /**
     * 采用插入排序，感觉可以优化
     * @param nums1 nums1
     * @param m m
     * @param nums2 nums2
     * @param n n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m] = nums2[i];
            int j = m;
            for (; j >  0 && nums2[i] < nums1[j - 1]; j--) {
                nums1[j] = nums1[j - 1];
            }
            nums1[j] = nums2[i];
            m ++;
        }
    }

    public static void mergeChange(int[] nums1, int m, int[] nums2, int n){
        m --;
        n --;
        while (m + n >= -1){
            if (m == -1){
                nums1[m + n + 1] = nums2[n];
                n --;
            }
            else if (n == -1){
                nums1[m + n + 1] = nums1[m];
                m --;
            }
            else{
                if (nums1[m] > nums2[n]){
                    nums1[m + n + 1] = nums1[m];
                    m --;
                }
                else{
                    nums1[m + n + 1] = nums2[n];
                    n --;
                }
            }
        }
    }
}

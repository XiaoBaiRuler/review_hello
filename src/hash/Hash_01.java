package hash;

import java.util.*;

/**
 * @Author xiaobai
 * @Date 2021/1/22 19:42
 * @Version 1.0
 */
public class Hash_01 {
    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }
    public static int[] intersection(int[] nums1, int[] nums2) {
        int all1 = nums1.length;
        int all2 = nums2.length;
        HashSet<Integer> item = new HashSet<>();
        for (int i = 0; i < all2; i++) {
            item.add(nums2[i]);
        }
        int count = 0;
        for (int i = 0; i < all1; i++) {
            if (item.contains(nums1[i])){
                nums2[count] = nums1[i];
                item.remove(nums1[i]);
                count ++;
            }
        }
        if (count == all2){
            return nums2;
        }
        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            result[i] = nums2[i];
        }
        return result;
    }
}

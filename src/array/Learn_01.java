package array;

import java.util.HashMap;

/**
 *
 * @Author xiaobai
 * @Date 2020/12/16 14:40
 * @Version 1.0
 */
public class Learn_01 {
    public static void main(String[] args) {
        int[] nums1 = {-3, 3, 3, 4, 90, 19};
        System.out.println(removeSortedListDuplicates(nums1));
        int[] nums2 = {1, 3, 5, 4, 1, 1, 5, 8, 9, 5};
        System.out.println(removeUnorderedListDuplicates(nums2));
    }

    /**
     * 清理<b>排序</b>数组中的重复项，仅对数组进行操作，不返回数组
     * @param nums 数组
     * @return 长度
     */
    public static int removeSortedListDuplicates(int[] nums){
        int length = nums.length;
        if (length == 0){
            return 0;
        }
        int i = 0;
        for (int j = 1; j < length; j++) {
            if (nums[j] != nums[i]){
                i ++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    /**
     * 清理<b>排序</b>数组中的重复项，仅对数组进行操作，不返回数据
     *
     * @param nums 数组
     * @return 长度
     */
    public static int removeUnorderedListDuplicates(int[] nums){
        int all = nums.length;
        int j = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < all; i ++){
            if (!map.containsKey(nums[i])){
                map.put(nums[i], i);
                nums[j] = nums[i];
                j ++;
            }
        }
        return map.size();
    }
}

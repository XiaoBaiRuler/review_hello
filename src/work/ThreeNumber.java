package work;

import java.util.*;

/**
 * @Author xiaobai
 * @Date 2020/12/22 21:39
 * @Version 1.0
 */
public class ThreeNumber {
    public static void main(String[] args) {
        int[] nums = {3,0,-2,-1,1,2};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        int all = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        HashMap<String, Integer> hashMap = new HashMap<>();
        int i = 0;
        int j = 1;
        int k = 2;
        int item = 0;
        while (i < all){
            while (j < all){
                while (k < all){
                    item = nums[i] + nums[j] + nums[k];
                    if (item == 0 && filterIndex(i, j, k)){
                        String key = "" + nums[i] + nums[j] + nums[k];
                        if (!hashMap.containsKey(key)){
                            hashMap.put(key, 1);
                            ArrayList<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            lists.add(list);
                        }
                    }
                    k ++;
                }
                j ++;
                k = j;
            }
            i ++;
            j = i;
        }
        return lists;
    }
    public static boolean filterIndex(int i, int j, int k){
        if (i == j || i == k || j == k){
            return false;
        }
        return true;
    }

}


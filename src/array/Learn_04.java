package array;

import java.util.HashMap;

/**
 * @Author xiaobai
 * @Date 2020/12/16 20:54
 * @Version 1.0
 */
public class Learn_04 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3};
        System.out.println(containsDuplicate(nums));
    }

    public static boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                return true;
            } else {
                map.put(num, 0);
            }
        }
        return false;
    }
}

package work;

import java.util.HashMap;

/**
 * @Author xiaobai
 * @Date 2020/12/15 9:19
 * @Version 1.0
 */
public class Learn {

    public static void main(String[] args) {
        int[] test = {1,1,2};
        deleteSame(test);
    }

    public static int deleteSame(int[] nums){
        int all = nums.length;
        int item = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < all; i ++){
            if (map.containsKey(nums[i])){
                for (int j = i; j < all; j ++){
                    nums[j] = nums[j + 1];
                    item ++;
                    all --;
                }
            }else{
                map.put(nums[i], i);
            }
        }
        for (int i = 0; i < nums.length - item; i++) {
            System.out.println(nums[i]);
        }
        return nums.length - item;
    }
}

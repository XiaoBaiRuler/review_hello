package desgin;

import java.util.Arrays;

/**
 * @Author xiaobai
 * @Date 2021/1/28 11:01
 * @Version 1.0
 */
public class Design_01 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution obj = new Solution(nums);
        System.out.println(Arrays.toString(obj.shuffle()));
        System.out.println(Arrays.toString(obj.reset()));
    }


}

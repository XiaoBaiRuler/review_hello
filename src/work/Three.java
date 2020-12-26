package work;

import jdk.internal.util.xml.impl.Input;

import java.util.ArrayList;

/**
 * @Author xiaobai
 * @Date 2020/12/15 8:33
 * @Version 1.0
 */
public class Three {
    public static void main(String[] args) {
        int[] nums = {-3, 4, 3, 90};
        int target = 0;
        ArrayList<Integer> result = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target){
                    result.add(i);
                    result.add(j);
                }
            }
        }
        int flag = 0;
        int[] last = new int[result.size()];
        for (Integer a : result) {
            System.out.println(a);
            last[flag] = a;
            flag ++;
        }
    }
}

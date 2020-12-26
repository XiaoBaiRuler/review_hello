package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * @Author xiaobai
 * @Date 2020/12/17 19:02
 * @Version 1.0
 */
public class Learn_07 {
    public static void main(String[] args) {
        int[] digits = {9};
        System.out.println(Arrays.toString(plusOne(digits)));
    }
    public static int[] plusOne(int[] digits) {
        Stack<Integer> stack = new Stack<>();
        int all = digits.length;
        int i = 0;
        for (; i < all - 1; i++) {
            stack.push(digits[i]);
        }
        stack.push(digits[i] + 1);
        ArrayList<Integer> list = new ArrayList<>();

        //扩散信号
        boolean flag = false;
        if (stack.peek() > 9){
            list.add(stack.pop() % 10);
            flag = true;
        }
        if (stack.isEmpty()){
            list.add(1);
        }
        //添加1
        while (!stack.isEmpty()){
            if (flag){
                flag = spread(stack, true, list);
            }else{
                list.add(stack.pop());
            }
        }
        //反转
        int item = list.size();
        int k = item - 1;
        int[] result = new int[item];
        for (int j = 0; j < item; j++) {
            result[j] = list.get(k);
            k --;
        }
        return result;
    }

    public static boolean spread(Stack<Integer> stack, boolean flag, ArrayList<Integer> list){
        while (flag && !stack.isEmpty()){
            if (stack.peek() + 1 > 9){
                list.add((stack.pop() + 1) % 10);
                flag = true;
            }
            else{
                list.add(stack.pop() + 1);
                return false;
            }
        }
        list.add(1);
        return false;
    }
}

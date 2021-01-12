package stack;

import java.util.Stack;

/**
 * @Author xiaobai
 * @Date 2021/1/7 21:27
 * @Version 1.0
 */
public class Stack_01 {
    public static void main(String[] args) {
        String s = "";
        System.out.println(isValid(s));

    }
    public static boolean isValid(String s) {
        if ("".equals(s)){
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        int all = s.length();
        int i = 0;
        while (i < all){
            int item = s.charAt(i);
            if (item == 40 || item == 91 || item == 123){
                stack.push(item);
            }
            else if (item == 41 || item == 93 || item == 125){
                if(stack.isEmpty()){
                    return false;
                }
                int b = stack.pop() + item;
                if (!(b == 81 || b == 184 || b == 248)){
                    return false;
                }
            }
            i ++;
        }
        if (stack.isEmpty()){
            return true;
        }
        return false;
    }
}

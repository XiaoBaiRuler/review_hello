package work;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.lang.reflect.Array;
import java.sql.Time;
import java.util.*;

/**
 * @Author xiaobai
 * @Date 2020/12/14 14:59
 * @Version 1.0
 */
public class Second {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String[] input = {"eat","tea","tan","ate","nat","bat"};
        Stack<String> stack1 = new Stack<String>();
        Stack<String> result = new Stack<String>();
        List<List<String>> all = new ArrayList<>();
        Collections.addAll(stack1,input);
        String str1 = "";
        String str2 = "";
        do{
            Stack<String> stack2 = new Stack<String>();
            stack2.push(stack1.pop());
            str2 = stack2.peek();
            Iterator<String> it = stack1.iterator();
            while (it.hasNext()){
                str1 = stack1.peek();
                if (str1.equals(str2)){
                    stack2.push(stack1.pop());
                    continue;
                }
                if (isSame(str1,str2)){
                    stack2.push(stack1.pop());
                }else{
                    result.push(stack1.pop());
                }
            }
            all.add(stack2);
            stack1.addAll(result);
            result.clear();
        }while (!stack1.isEmpty());
        long endTime = System.currentTimeMillis();
        System.out.println((double)(endTime - startTime)/1000);
        System.out.println(all);
    }

    public static boolean isSame(String str1, String str2){
        if (str1.length() != str2.length()){
            return false;
        }else{
            char[] chars1 = str1.toCharArray();
            char[] chars2 = str2.toCharArray();
            Arrays.sort(chars1);
            Arrays.sort(chars2);
            if (String.valueOf(chars1).equals(String.valueOf(chars2))){
                return true;
            }else{
                return false;
            }
        }
    }
}

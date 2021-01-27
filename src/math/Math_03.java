package math;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author xiaobai
 * @Date 2021/1/27 23:27
 * @Version 1.0
 */
public class Math_03 {
    public static void main(String[] args) {
        System.out.println(fizzBuzz(15).toString());
    }
    public static List<String> fizzBuzz(int n) {
        int j = 0;
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if ((i - (i / 3) * 3) == 0){
                j ++;
            }

            if ((i - (i / 5) * 5) == 0){
                if (j == 0){
                    list.add("Buzz");
                }
                else{
                    list.add("FizzBuzz");
                }
                j ++;
            }
            else if (j == 1){
                list.add("Fizz");
            }
            if (j == 0){
                list.add("" + i);
            }
            j = 0;
        }
        return list;
    }
}

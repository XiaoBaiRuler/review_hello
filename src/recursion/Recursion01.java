package recursion;

import java.util.Arrays;

/**
 * @Author xiaobai
 * @Date 2020/12/31 22:57
 * @Version 1.0
 */
public class Recursion01 {
    public static void main(String[] args) {
//        permute("abc");
        System.out.println(factorialByRecursion(7));
    }

    /**
     * 递归读取int的每一位数
     * @param n n
     */
    public static void printOutput(int n){
        if (n >= 10){
            printOutput(n / 10);
        }
        System.out.println(n % 10);
        System.out.println(n - (n / 10) * 10);
    }

    /**
     * 递归读取double的每一位数
     * @param n double
     */
    public static void printOutputDouble(double n){
        double max = 10;
        if (n < 0){
            n = -n;
            System.out.print("-");
        }
        if (n >= max){
            printOutputDouble(Math.floor(n / max));
        }
        System.out.print((int)(n - Math.floor((n / max)) * 10) + "");
    }

    /**
     * 递归展示奇数的1的个数
     * @param n number
     * @return int
     */
    public static int printOutputByteNumber(int n){
        // 0
        if (n == 0){
            return 0;
        }
        // 奇数
        if (n % 2 != 0){
            return printOutputByteNumber(n / 2) + 1;
        }
        // 偶数返回-1
        return -1;
    }

    public static void permute(String str){
        permute(str.toCharArray(), 0, str.length() - 1);
    }

    /**
     * 递归求字符串的全排列
     * @param str str
     * @param low low
     * @param high high
     */
    private static void permute(char[] str, int low, int high){
        if (low == high){
            System.out.println(String.valueOf(str));
        }
        else{
            for (int j = low; j <= high; j++) {
                if (j != low){
                    char item = str[low];
                    str[low] = str[j];
                    str[j] = item;
                    permute(str, low + 1, high);
                    item = str[low];
                    str[low] = str[j];
                    str[j] = item;
                }
                else{
                    permute(str, low + 1, high);
                }
            }
        }
    }

    /**
     * 递归求阶乘
     * 时间复杂度: O(n),感觉堆栈展开也需要时间，循环比它更好吧
     * 空间复杂度: O(n),堆栈的空间
     * @param n n
     * @return int
     */
    public static int factorialByRecursion(int n){
        if (n <= 1){
            return 1;
        }
        else{
            return factorialByRecursion(n - 1) * n;
        }
    }
}

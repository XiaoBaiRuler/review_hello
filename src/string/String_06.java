package string;


import java.util.ArrayList;

/**
 * @Author xiaobai
 * @Date 2020/12/21 16:40
 * @Version 1.0
 */
public class String_06 {

    public static void main(String[] args) {
        String str = "0 134";
        System.out.println(myAtoi(str));
    }

    /**
     * 自定义将字符串转为整数
     * 当为空或第一个字符不为空格、数字或负号时，返回0
     * 超出整数范围，返回最大值和最小值
     * @param s 字符串
     * @return int
     */
    public static int myAtoi(String s) {
        //清空多余空格
        s = s.trim();
        if ("".equals(s)){
            return 0;
        }
        //区分是否带符号
        int i = 0;
        char c = ' ';
        char reduce = '-';
        char add = '+';
        char ar = ' ';
        char white = ' ';
        char zero = '0';
        boolean flag = false;
        c = s.charAt(i);
        if (!isNumber(c)){
            if (c == reduce || c == add){
                flag = true;
                ar = c;
                i ++;
            }
            else{
                return 0;
            }
        }
        while (i < s.length() &&(c = s.charAt(i)) == zero){
            i ++;
        }
        System.out.println(i);
        //尽可能过滤数字
        String rStr = filterNumbers(s, flag, ar, i);
        //对特殊情况进行处理
        if ("".equals(rStr) || "-".equals(rStr) || "+".equals(rStr)){
            return 0;
        }
        //过滤数字达到Long的上下限
        int f = 12;
        if (rStr.length() > f){
            if (ar == white || ar == add){
                return Integer.MAX_VALUE;
            }else{
                return Integer.MIN_VALUE;
            }

        }
        //过滤数字达到Integer的上下限
        long l = Long.parseLong(rStr);
        if (l >= Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if (l <= Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        return (int)l;
    }

//    public static int countNonZero(String rStr){
//        int count = 0;
//        for (int i = 0; i < rStr.length(); i++) {
//            if (rStr.charAt(i) == 48){
//                count ++;
//            }
//            else{
//                break;
//            }
//        }
//    }

    public static String filterNumbers(String s, boolean filter, char ar, int i){
        StringBuilder result = new StringBuilder();
        char c;
        char white = ' ';
        if (!filter){
            while(i < s.length() && (isNumber(c = s.charAt(i)))){
                if (c != white){
                    result.append(c);
                }
                i++;
            }
        }
        else{
            result.append(ar);
            while(i < s.length() && (isNumber(c = s.charAt(i)))){
                result.append(c);
                i++;
            }
        }
        return result.toString();
    }

    public static boolean isNumber(char c){
        int a0 = 48;
        int a9 = 57;
        if ( c < a0 || c > a9 ){
            return false;
        }
        else{
            return true;
        }
    }

}

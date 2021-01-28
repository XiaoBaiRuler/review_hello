package math;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author xiaobai
 * @Date 2021/1/28 11:48
 * @Version 1.0
 */
public class Math_04 {
    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
    public static int romanToInt(String s) {
        int all = s.length();
        int count = 0;

        for (int i = 0; i < all; i++) {
            char item = s.charAt(i);
            char next = ' ';
            if (i + 1  < all){
                next = s.charAt(i + 1);
            }
            // I
            if (item == 'I' && next != ' ' && next != 'V' && next != 'X'){
                count += 1;
            }
            else if (item == 'I' && next == 'V'){
                count += 4;
                i ++;
            }
            else if (item == 'I' && next == 'X'){
                count += 9;
                i ++;
            }
            else if (item == 'I'){
                count += 1;
            }
            // V
            if (item == 'V'){
                count += 5;
            }
            // X
            if (item == 'X' && next != ' ' && next != 'L' && next != 'C'){
                count += 10;
            }
            else if (item == 'X' && next == 'L'){
                count += 40;
                i ++;
            }
            else if (item == 'X' && next == 'C'){
                count += 90;
                i ++;
            }
            else if (item == 'X'){
                count += 10;
            }
            // L
            if (item == 'L'){
                count += 50;
            }
            // C
            if (item == 'C' && next != ' ' && next != 'D' && next != 'M'){
                count += 100;
            }
            else if (item == 'C' && next == 'D'){
                count += 400;
                i ++;
            }
            else if (item == 'C' && next == 'M'){
                count += 900;
                i ++;
            }
            else if (item == 'C'){
                count += 100;
            }
            // D
            if (item == 'D'){
                count += 500;
            }
            // M
            if (item == 'M'){
                count += 1000;
            }
        }
        return count;
    }
}

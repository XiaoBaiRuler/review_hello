package hash;

import java.util.HashSet;

/**
 * @Author xiaobai
 * @Date 2021/1/22 20:53
 * @Version 1.0
 */
public class Hash_02 {
    public static void main(String[] args) {
        System.out.println(isHappy(19));

    }
    public static boolean isHappy(int n) {
        if (n == 0){
            return false;
        }
        HashSet<Integer> hashSet = new HashSet<>();
        while (n != 1){
            hashSet.add(n);
            n = change(n);
            if (hashSet.contains(n)){
                return false;
            }
        }
        return true;
    }


    private static int change(int n){
        int count = 0;
        int item = 0;
        while ((item = n % 10) != 0 || n != 0){
            count += item * item;
            n = n / 10;
        }
        return count;
    }
}

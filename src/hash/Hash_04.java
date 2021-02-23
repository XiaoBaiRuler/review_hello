package hash;

import java.util.HashSet;

/**
 * @Author xiaobai
 * @Date 2021/2/23 13:38
 * @Version 1.0
 */
public class Hash_04 {
    public static void main(String[] args) {

    }
    public static int numJewelsInStones(String jewels, String stones) {
        int all1 = jewels.length();
        HashSet<Character> hashSet = new HashSet<>();
        for (int i = 0; i < all1; i++) {
            hashSet.add(jewels.charAt(i));
        }
        int all2 = stones.length();
        int result = 0;
        for (int i = 0; i < all2; i++) {
            if (hashSet.contains(stones.charAt(i))){
                result += 1;
            }
        }
        return result;
    }
}

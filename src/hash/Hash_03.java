package hash;

import com.sun.deploy.security.DeployClientAuthCertStore;
import javafx.util.Pair;
import sun.rmi.transport.Channel;

import java.util.*;

/**
 * @Author xiaobai
 * @Date 2021/2/23 12:29
 * @Version 1.0
 */
public class Hash_03 {
    public static void main(String[] args) {
        String s = "abab";
        String t = "baba";
        System.out.println(isIsomorphic(s, t));
        System.out.println(isIsomorphicChange(s,t));
    }
    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Integer> hs = new HashMap<>();
        HashMap<Character, Integer> ht = new HashMap<>();
        int all = s.length();
        for (int i = 0; i < all; i++) {
            char itemS = s.charAt(i);
            if (!hs.containsKey(itemS)) {
                hs.put(itemS, 1);
            }
            else{
                hs.put(itemS, hs.get(itemS) + 1);
            }
            char itemT = t.charAt(i);
            if (!ht.containsKey(itemT)) {
                ht.put(itemT, 1);
            }
            else{
                ht.put(itemT, ht.get(itemT) + 1);
            }
        }
        if (hs.size() != ht.size()){
            return false;
        }
        else{
            PriorityQueue<Pair<Character, Integer>> ps = new PriorityQueue<>(Comparator.comparingInt(Pair::getValue));
            PriorityQueue<Pair<Character, Integer>> pt = new PriorityQueue<>(Comparator.comparingInt(Pair::getValue));
            for (Character i: hs.keySet()){
                ps.add(new Pair<>(i, hs.get(i)));
            }
            for (Character j: ht.keySet()){
                pt.add(new Pair<>(j, ht.get(j)));
            }
            // 验证类型是否相同
            while (!ps.isEmpty()){
                Pair<Character, Integer> pat = pt.remove();
                Pair<Character, Integer> pas = ps.remove();
                if (!pat.getValue().equals(pas.getValue())){
                    return false;
                }
            }
            // 验证顺序字符个数是否相同
            ArrayList<String> list = new ArrayList<>();
            for (int i = all - 1; i >= 0; i--) {
                if (!hs.get(s.charAt(i)).equals(ht.get(t.charAt(i)))){
                    return false;
                }
                else{
                    list.add(s.charAt(i) + "" + t.charAt(i));
                }
            }
            // 验证字符是否一一对应
            HashSet<String> hashSet = new HashSet<>(list);
            HashSet<Character> item = new HashSet<>(hashSet.size());
            for (String str: hashSet) {
                if (!item.contains(str.charAt(0))){
                    item.add(str.charAt(0));
                }
                else{
                    return false;
                }
            }
            for (int i = 0; i < all; i++) {
                if (!hashSet.contains(s.charAt(i) + "" + t.charAt(i))){
                    return false;
                }
            }
            return true;
        }
    }


    public static boolean isIsomorphicChange(String s, String t){
        if (s.length() != t.length()){
            return false;
        }
        HashMap<Character, Character> map = new HashMap<>();
        int is = s.length();
        for (int i = 0; i < is; i++) {
            if (!map.containsKey(s.charAt(i))){
                if (map.containsValue(t.charAt(i))){
                    return false;
                }
                map.put(s.charAt(i), t.charAt(i));
            }
            else{
                if (map.get(s.charAt(i)) != t.charAt(i)){
                    return false;
                }
            }
        }
        return true;
    }
}

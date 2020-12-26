package string;

import java.util.HashMap;

/**
 * @Author xiaobai
 * @Date 2020/12/21 9:46
 * @Version 1.0
 */
public class String_04_01 {
    public static void main(String[] args) {
        String s = "aabb";
        String t = "aabb";
        System.out.println(isAnagram(s, t));
    }
    public static boolean isAnagram(String s, String t) {

        int allS = s.codePointCount(0, s.length());
        int allT = t.codePointCount(0, t.length());
        HashMap<Integer, Integer> mapS = new HashMap<>();
        HashMap<Integer, Integer> mapT = new HashMap<>();

        if (allS != allT){
            return false;
        }
        else{
            int sc = 0;
            int st = 0;
            for (int i = 0; i < allS; i++) {
                sc = s.codePointAt(i);
                st = t.codePointAt(i);
                if (!mapS.containsKey(sc)){
                    mapS.put(sc, 1);
                }
                else{
                    mapS.put(sc, mapS.get(sc) + 1);
                }
                if (!mapT.containsKey(st)){
                    mapT.put(st, 1);
                }
                else{
                    mapT.put(st, mapT.get(st) + 1);
                }
            }
            if (mapS.size() != mapT.size()){
                return false;
            }
            else{
                for(Integer a : mapS.keySet()){
                    if (!mapT.containsKey(a)){
                        return false;
                    }
                    else{
                        if (!mapT.get(a).equals(mapS.get(a))){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}

package work;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author xiaobai
 * @Date 2020/12/13 19:37
 * @Version 1.0
 */
public class First {

    public static void main(String[] args) {

        String s = " ";
        Integer maxLetters;
        Integer minSize;
        Integer maxSize;

        System.out.print("s:");
        Scanner sc = new Scanner(System.in);
        s = sc.nextLine();
        System.out.print("maxLetters:");
        maxLetters = sc.nextInt();
        System.out.print("minSize:");
        minSize = sc.nextInt();
        System.out.print("maxSize:");
        maxSize = sc.nextInt();
        sc.close();
        ArrayList<String> result = new ArrayList<>();

        for (int i = minSize; i <= maxSize; i++) {
            // 获取匹配正则表达式
            Pattern r = Pattern.compile(getPattern(i));
            // 收敛
            int maxInteger = getMaxInteger(s.length(), i);
            for (int j = 0; j < maxInteger; j++) {
                String item = s.substring(j);
                Matcher m = r.matcher(item);
                while (m.find()) {
                    String aString = m.group();
                    if (getDifferentCharacter(aString) <= maxLetters){
                        System.out.println(aString);
                        result.add(aString);
                    }
                }
               if (s.length() / i > i){
                    maxInteger -= 1;
                }

            }
        }
        System.out.println(getCount(result));
    }

    public static String getPattern(Integer max) {
        String pattern = "";
        for (int i = 0; i < max; i++) {
            pattern += ".";
        }
        return pattern;
    }

    public static Integer getMaxInteger(Integer total, Integer max) {
        if (total % max == 0){
            return total / max;
        }else{
            if (total / max > max){
                return total / max;
            }else{
                return total / max + 1;
            }
        }
    }

    public static Integer getDifferentCharacter(String aString) {
        int[] count = new int[26];
        for (int i = 0; i < aString.length(); i++) {
            count[aString.charAt(i) - 'a'] = 1;
        }
        int item = 0;
        for (int i = 0; i < count.length; i ++){
            if (count[i] == 1){
                item ++;
            }
        }
        return item;
    }

    public static Integer getCount(ArrayList<String> result){
        Map<String, Integer> map = new HashMap<>(result.size());
        for (String str : result){
            Integer num = map.get(str);
            map.put(str, num == null ? 1 : num + 1);
        }
        ArrayList<Integer> countResult = new ArrayList<>();
        for (Integer v: map.values()){
            countResult.add(v);
        }
        if (countResult.isEmpty()){
            return 0;
        }
        countResult.sort(null);
        return countResult.get(countResult.size() -1);
    }

}
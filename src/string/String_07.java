package string;

/**
 * @Author xiaobai
 * @Date 2020/12/21 16:45
 * @Version 1.0
 */
public class String_07 {
    public static void main(String[] args) {
        String haystack = "aaaaab";
        String needle = "aaab";
        System.out.println(strStr(haystack, needle));
    }

    /**
     * 找出haystack中needle字符串第一次出现的位置
     * @param haystack String
     * @param needle String
     * @return int
     */
    public static int strStr(String haystack, String needle) {

        int allH = haystack.length();
        int allN = needle.length();
        if ("".equals(needle)){
            return 0;
        }
        if (allH < allN){
            return -1;
        }
        else if (allH == allN){
            if (haystack.equals(needle)){
                return 0;
            }
            else{
                return -1;
            }
        }
        int j = 0;
        int count = 0;
        int i = 0;
        while (i < allH){
            if (haystack.charAt(i) == needle.charAt(j)){
                i ++;
                j ++;
                count ++;
            }
            else{
                i = i - count + 1;
                count = 0;
                j = 0;
            }
            if (count == allN){
                return i - j;
            }
        }
        return -1;
    }
}


package other;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author xiaobai
 * @Date 2021/1/28 17:35
 * @Version 1.0
 */
public class Other_04 {
    public static void main(String[] args) {
        System.out.println(generate(5));
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        if (numRows == 0){
            return lists;
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        lists.add(list);
        int count = 1;
        while (count < numRows){
            ArrayList<Integer> item = new ArrayList<>();
            item.add(1);
            Iterator<Integer> it = list.iterator();
            int pre = it.next();
            int next;
            while (it.hasNext()){
                next = it.next();
                item.add(pre + next);
                pre = next;
            }
            item.add(1);
            lists.add(item);
            list = item;
            count ++;
        }
        return lists;
    }
}

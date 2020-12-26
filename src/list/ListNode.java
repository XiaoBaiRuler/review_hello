package list;

/**
 * @Author xiaobai
 * @Date 2020/12/23 9:25
 * @Version 1.0
 */
public class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    ListNode(int x){
        val = x;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

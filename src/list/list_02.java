package list;

/**
 * @Author xiaobai
 * @Date 2020/12/23 9:23
 * @Version 1.0
 */
public class list_02 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, null);
        for (int i = 1; i < 4; i++) {
            ListNode item = new ListNode(i + 1, null);
            ListNode h = head;
            while (h.next != null){
                h = h.next;
            }
            h.next = item;
        }
        head = removeNthFromEnd(head, 1);
        System.out.println("---------");
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    /**
     * 删除倒数第n个节点，双指针
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n){
        ListNode returnItem = head;
        ListNode item = head;
        ListNode pre = head;
        int count = 0;
        while (head != null){
            count ++;
            if (count > n + 1){
                pre = pre.next;
            }
            if (count > n){
                item = item.next;
            }
            head = head.next;
        }
        if (n == 1 && count == n){
            returnItem = null;
        }
        else if (count == n){
            returnItem = pre.next;
        }
        else{
            pre.next = item.next;
        }
        return returnItem;
    }
}


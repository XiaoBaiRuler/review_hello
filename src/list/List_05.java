package list;

/**
 * @Author xiaobai
 * @Date 2020/12/28 18:17
 * @Version 1.0
 */
public class List_05 {
    public static void main(String[] args) {
        int[] a = {1, 1, 1, 1, 2};
        ListNode head = addListNode(a);
        System.out.println(isPalindrome(head));
    }

    public static boolean isPalindrome(ListNode head) {

        ListNode cHead = head;
        int count = 0;
        while (cHead != null){
            count ++;
            cHead = cHead.next;
        }
        // 特殊情况
        if (count <= 1){
            return true;
        }
        int t = count / 2;

        ListNode rHead = head;
        ListNode node = head;
        ListNode pre = null;
        ListNode next = null;
        while (node != null){
            next = node.next;
            if (t == 1){
                rHead = node;
                node.next = pre;
                pre = node;
                break;
            }
            t --;
            node.next = pre;
            pre = node;
            node = next;
        }
        if (count % 2 != 0){
            next = next.next;
        }
        while (next != null){
            if (rHead.val != next.val){
                return false;
            }
            rHead = rHead.next;
            next = next.next;
        }
        return true;
    }

    public static ListNode addListNode(int[] nodes){
        ListNode head = new ListNode(1, null);
        for (int i = 1; i < nodes.length; i++) {
            ListNode item = new ListNode(nodes[i], null);
            ListNode h = head;
            while (h.next != null){
                h = h.next;
            }
            h.next = item;
        }
        return head;
    }

    public static void listNodeToString(ListNode node){
        while (node != null){
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
}

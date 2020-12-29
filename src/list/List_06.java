package list;

/**
 * @Author xiaobai
 * @Date 2020/12/28 18:18
 * @Version 1.0
 */
public class List_06 {

    public static void main(String[] args) {
        int[] a = {1};
        ListNode head = addListNode(a);
        System.out.println(hasCycle(head));
    }

    public static boolean hasCycle(ListNode head) {
        ListNode node = head;
        int flag = 100001;
        while (node != null){
            if (node.val != flag){
                node.val = flag;
            }
            node = node.next;
            if (node == null){
                return false;
            }
            if (node.val == flag){
                return true;
            }
        }
        return false;
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

package list;


/**
 * @Author xiaobai
 * @Date 2020/12/24 12:46
 * @Version 1.0
 */
public class List_04 {

    public static void main(String[] args) {
        int[] li1 = {1, 2, 4};
        int[] li2 = {1, 3, 4};
        ListNode l1 = addListNode(li1);
        ListNode l2 = addListNode(li2);
        listNodeToString(l1);
        listNodeToString(l2);
        listNodeToString(mergeTwoLists(l1, l2));

    }
    
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode next1 = l1.next;
        ListNode next2 = l2.next;
        ListNode pre = null;
        // 初始化先pre
        if (next1.val >= next2.val){
            pre = next2;
            next2 = next2.next;
        }
        else{
            pre = next1;
            next1 = next1.next;
        }
        pre = pre.next;




        return l1;
    }

    public static ListNode change(ListNode l1, ListNode l2){
        ListNode result = null;
        if (l1.val > l2.val){
            result = l2;
        }else{
            result = l1;
        }



        return result;
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

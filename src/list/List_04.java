package list;


/**
 * @Author xiaobai
 * @Date 2020/12/24 12:46
 * @Version 1.0
 */
public class List_04 {

    public static void main(String[] args) {
        int[] li1 = {};
        int[] li2 = {1, 3, 4, 6};
        ListNode l1 = addListNode(li1);
        ListNode l2 = addListNode(li2);
        listNodeToString(l1);
        listNodeToString(l2);
        listNodeToString(mergeTwoLists(l1, l2));

    }
    
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }else if (l2 == null){
            return l1;
        }
        ListNode next1 = l1;
        ListNode next2 = l2;
        ListNode pre;
        // 初始化
        if (next1.val >= next2.val){
            pre = next2;
            next2 = next2.next;
        }
        else{
            pre = next1;
            next1 = next1.next;
        }
        ListNode result = pre;
        while (true){
            // next1 == null && next2 != null
            if (next1 == null && next2 != null){
                pre.next = next2;
                break;
            }
            else if (next2 == null && next1 != null){
                pre.next = next1;
                break;
            }
            else if (next1 == null){
                break;
            }

            // 当1 > 2
            if(next1.val >= next2.val){
                pre.next = next2;
                pre = pre.next;
                next2 = next2.next;
            }
            // 当1 < 2
            else{
                pre.next = next1;
                pre = pre.next;
                next1 = next1.next;
            }
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

package list;

import java.util.LinkedList;

/**
 * @Author xiaobai
 * @Date 2020/12/24 12:46
 * @Version 1.0
 */
public class List_03 {

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
        head = reverseList(head);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }

    }

    public static ListNode reverseList(ListNode head) {
        ListNode pReversedHead = head;
        ListNode pNode = head;
        ListNode pPrev = null;

        while (pNode != null){
            ListNode pNext = pNode.next;
            if (pNext == null){
                pReversedHead = pNode;
            }
            pNode.next = pPrev;
            pPrev = pNode;
            pNode = pNext;
        }
        return pReversedHead;
    }

    /**
     * 遍历，改变next的方向，最后作为索引
     * @param head
     * @return
     */
    public static ListNode reverseListLearn(ListNode head){
        ListNode ret = head;
        ListNode node = head;
        ListNode per = null;
        while (node != null){
            ListNode nex = node.next;
            if (nex == null){
                ret = node;
            }
            node.next = per;
            per = node;
            node = nex;
        }
        return ret;
    }

}

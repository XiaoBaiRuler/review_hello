package list;
/**
 * @Author xiaobai
 * @Date 2020/12/23 9:13
 * @Version 1.0
 */
public class List_01 {
    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        ListNode b= new ListNode(5);
        node.next = b;
        ListNode c = new ListNode(1);
        b.next = c;
        ListNode d = new ListNode(9);
        c.next = d;
        d.next = null;
        deleteNode(b);
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }

    /**
     * 删除非末尾的节点
     * @param node 节点
     */
    public static void deleteNode(ListNode node) {
        //将当前一个和下一个交换
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }
}

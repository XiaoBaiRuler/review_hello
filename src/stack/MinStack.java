package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @Author xiaobai
 * @Date 2021/1/7 20:28
 * @Version 1.0
 */
public class MinStack {

    private int size;
    private Node root;

    /** initialize your data structure here. */
    public MinStack() {
        root = new Node(null, null);
        size = 0;
    }

    public void push(int x) {
        size ++;
        root.next = new Node(x, root.next);
    }

    public void pop() {
        if (size != 0){
            size --;
            root.next = root.next.next;
        }
    }

    public int top() {
        return root.next.data;
    }

    public int getMin() {
        if (size == 0){
            return Integer.MIN_VALUE;
        }
        Node item = root.next;
        int min = Integer.MAX_VALUE;
        while (item != null){
            if (item.data < min){
                min = item.data;
            }
            item = item.next;
        }
        return min;
    }

    private static class Node{
        public Integer data;
        public Node next;

        public Node(Integer data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}

package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author xiaobai
 * @Date 2021/1/19 18:38
 * @Version 1.0
 */
public class Tree_09 {
    public static void main(String[] args) {

    }
    public static Node connect(Node root) {
        Node item = root;
        if (root == null){
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(item);
        while (!queue.isEmpty()){
            int count = queue.size();
            for (int i = 1; i <= count; i++) {
                Node node = queue.poll();
                if (i == count){
                    node.next = null;
                }else{
                    node.next = queue.peek();
                }
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
        }
        return root;
    }
}

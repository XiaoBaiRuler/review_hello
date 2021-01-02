package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author xiaobai
 * @Date 2020/12/31 11:08
 * @Version 1.0
 */
public class Tree_04 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, null);
        LearnBinaryTree.buildACompleteBinaryTree(root, 3);
        System.out.println(levelOrder(root));
    }

    public static List<List<Integer>> levelOrderOld(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            ArrayList<TreeNode> item = new ArrayList<>(queue);
            ArrayList<Integer> it = new ArrayList<>();
            for(TreeNode i : item){
                it.add(i.val);
            }
            result.add(it);
            queue = getALevel(queue);
        }
        return result;
    }
    public static Queue<TreeNode> getALevel(Queue<TreeNode> queue){
        Queue<TreeNode> newQueue = new LinkedList<>();
        while (!queue.isEmpty()){
            TreeNode item = queue.remove();
            if (item.left != null){
                newQueue.add(item.left);
            }
            if (item.right != null){
                newQueue.add(item.right);
            }
        }
        return newQueue;
    }

    /**
     * 将迭代一个，变成每次迭代queue.size个
     * @param root root
     * @return result
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int all = queue.size();
            ArrayList<Integer> list = new ArrayList<>(all);
            for (int i = 0; i < all; i++) {
                TreeNode item = queue.remove();
                list.add(item.val);
                if (item.left != null){
                    queue.add(item.left);
                }
                if (item.right != null){
                    queue.add(item.right);
                }
            }
            result.add(list);
        }
        return result;
    }
}

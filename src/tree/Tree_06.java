package tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Author xiaobai
 * @Date 2021/1/6 16:30
 * @Version 1.0
 */
public class Tree_06 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, null);
        LearnBinaryTree.buildACompleteBinaryTree(root, 3);
        System.out.println(hasPathSum(root, 19));

    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null){
            return false;
        }
        Stack<Integer> lists = new Stack<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        lists.push(sum);
        TreeNode item = stack.pop();
        int s = lists.pop();
        do {
            while (item.left != null || item.right != null){
                s = s - item.val;
                if (item.right != null && item.left != null){
                    stack.push(item.right);
                    lists.push(s);
                    item = item.left;
                }
                else if (item.left == null){
                    item = item.right;
                }
                else{
                    item = item.left;
                }
            }
            s = s - item.val;
            if (s == 0){
                return true;
            }
            if (lists.isEmpty() && stack.isEmpty()){
                return false;
            }
            s = lists.pop();
            item = stack.pop();
        }while (item != null);
        return false;
    }
}

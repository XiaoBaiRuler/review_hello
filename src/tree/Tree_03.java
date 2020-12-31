package tree;


import java.util.*;

/**
 * @Author xiaobai
 * @Date 2020/12/31 10:10
 * @Version 1.0
 */
public class Tree_03 {
    public static void main(String[] args) {

    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int all = queue.size();
            int[] items = new int[all];
            for (int i = 0; i < all; i++) {
                TreeNode item = queue.remove();
                items[i] = item.val;
                if (item.left != null){
                    queue.add(item.left);
                }
                if (item.right != null){
                    queue.add(item.right);
                }
            }
            System.out.println(Arrays.toString(items));
        }
        return false;
    }


}

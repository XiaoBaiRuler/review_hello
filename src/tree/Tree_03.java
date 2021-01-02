package tree;


import java.util.*;

/**
 * @Author xiaobai
 * @Date 2020/12/31 10:10
 * @Version 1.0
 */
public class Tree_03 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, null);
        LearnBinaryTree.buildACompleteBinaryTree(root, 3);
        System.out.println(isSymmetric(root));
    }

    /**
     * 通过广度优先搜索，再填补上所在层次的节点为null，补全满二叉树，再检查所在层次元素是否镜像对称
     * @param root root
     * @return boolean
     */
    public static boolean isSymmetricOld(TreeNode root) {
        if (root == null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int all = queue.size();
            boolean flag = false;
            int[] items = new int[all];
            for (int i = 0; i < all; i++) {
                TreeNode item = queue.remove();
                if (item == null){
                    items[i] = Integer.MAX_VALUE;
                    continue;
                }
                else{
                    items[i] = item.val;
                }
                if (item.left != null){
                    queue.add(item.left);
                }
                else{
                    queue.add(null);
                }
                if (item.right != null){
                    queue.add(item.right);
                }
                else{
                    queue.add(null);
                }
            }
            if(!isItAxisymmetric(items)){
                return false;
            }
        }
        return true;
    }

    public static boolean isItAxisymmetric(int[] items){
        int total = items.length;
        int all = items.length / 2;
        for (int i = 0; i < all; i++) {
            if (items[i] != items[total - 1 - i]){
                return false;
            }
        }
        return true;
    }

    public static boolean isSymmetric(TreeNode root){
        if (root == null){
            return true;
        }
        else{
            return recursion(root, root);
        }
    }


    /**
     * 递归比较，左子树和右子树对称
     * @param a a
     * @param b b
     * @return boolean
     */
    private static boolean recursion(TreeNode a, TreeNode b) {
        if (a == null && b == null){
            return true;
        }
        // 左右没有对应上时，为false
        if (a == null || b == null){
            return false;
        }
        return a.val == b.val && recursion(a.left, b.right) && recursion(a.right, b.left);
    }

    /**
     * 广度优先搜索: 一个往左子树，一个往右子树
     * @param c c
     * @param d d
     * @return boolean
     */
    public static boolean iteration(TreeNode c, TreeNode d){
        return false;
    }

}

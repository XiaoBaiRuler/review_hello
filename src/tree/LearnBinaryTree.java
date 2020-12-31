package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author xiaobai
 * @Date 2020/12/30 8:03
 * @Version 1.0
 */
public class LearnBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, null);
        buildACompleteBinaryTree(root, 3);
//        subsequentTraversal(root);
        depthFirstSearch(root);

    }

    /**
     * 当前节点不为空，往当前节点插入节点作为左子树的父节点
     * @param root root
     * @param x x
     */
    public static TreeNode insertLeftNode(TreeNode root, int x){
        if (root == null){
            return null;
        }
        TreeNode item = root.left;
        root.left = new TreeNode(x, item, null);
        return root.left;
    }

    /**
     * 当前节点不为空，往当前节点插入节点作为右子树的父节点
     * @param root root
     * @param y y
     */
    public static TreeNode insertRightNode(TreeNode root, int y){
        if (root == null){
            return null;
        }
        TreeNode item = root.right;
        root.right = new TreeNode(y, null, item);
        return root.right;
    }

    /**
     * 按层次添加二叉树节点:满二叉树
     * @param root root
     * @param n 层次
     * @return root
     */
    public static TreeNode buildACompleteBinaryTree(TreeNode root, int n){
        ArrayList<TreeNode> items = new ArrayList<>();
        if (root == null){
            root = new TreeNode(1, null, null);
        }
        items.add(root);
        for (int i = 1; i <= n; i++) {
            items = buildALevelNode(items, (int) Math.pow(2, i));
        }
        return root;
    }

    /**
     * 给第几层添加节点:满二叉树
     * @param items 前一层节点列表
     * @param j 第几层
     * @return 当前层的节点列表
     */
    public static ArrayList<TreeNode> buildALevelNode(ArrayList<TreeNode> items, int j){
        int all = items.size();
        ArrayList<TreeNode> newItems = new ArrayList<>();
        for (int i = 0; i < all; i++) {
            newItems.add(insertLeftNode(items.get(i), j ++));
            newItems.add(insertRightNode(items.get(i), j ++));
        }
        return newItems;
    }

    /**
     * 递归:先序遍历二叉树
     * @param root root
     */
    public static void preorderTraversal(TreeNode root){
        System.out.println(root.val);
        if (root.left != null){
            preorderTraversal(root.left);
        }
        if (root.right != null){
            preorderTraversal(root.right);
        }
    }

    /**
     * 递归:中序遍历二叉树
     * @param root
     */
    public static void inOrderTraversal(TreeNode root){
        if (root.left != null){
            inOrderTraversal(root.left);
        }
        System.out.println(root.val);
        if (root.right != null){
            inOrderTraversal(root.right);
        }
    }

    /**
     * 递归:后续遍历二叉树
     * @param root root
     */
    public static void subsequentTraversal(TreeNode root){
        if (root != null){
            preorderTraversal(root.left);
            preorderTraversal(root.right);
            System.out.println(root.val);
        }
    }

    /**
     * 深度优先搜索: 使用堆栈
     * @param root root
     */
    public static void depthFirstSearch(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode item = stack.pop();
            System.out.print(item.val + " ");
            if (item.right != null){
                stack.push(item.right);
            }
            if (item.left != null){
                stack.push(item.left);
            }
        }
    }

    /**
     * 广度优先遍历: 使用队列
     * @param root root
     */
    public static void breadthFirstSearch(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode item = queue.remove();
            System.out.print(item.val + " ");
            if (item.left != null){
                queue.add(item.left);
            }
            if (item.right != null){
                queue.add(item.right);
            }
        }
    }

}

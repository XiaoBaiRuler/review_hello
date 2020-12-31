package tree;

import com.sun.xml.internal.bind.v2.model.core.ID;
import list.ListNode;

import java.util.*;

/**
 * @Author xiaobai
 * @Date 2020/12/29 10:41
 * @Version 1.0
 */
public class Tree_02 {

    static TreeNode pre = null;

    public static void main(String[] args) {
        TreeNode p = null;
        TreeNode root = new TreeNode(0, null, null);
        p = LearnBinaryTree.insertLeftNode(root, 4);
        p = LearnBinaryTree.insertRightNode(root, 6);
        LearnBinaryTree.insertLeftNode(p, 7);
        LearnBinaryTree.insertRightNode(p, 8);
        System.out.println(anotherIsValidBST(root));
    }

    public static boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    /**
     * 通过递归使用上下限的方法进行的二叉搜索树验证
     * @param root root
     * @param max max
     * @param min min
     * @return boolean
     */
    public static boolean isValid(TreeNode root, Integer max, Integer min){
        if (root == null){
            return true;
        }
        int val = root.val;
        if (min != null && val <= min){
            return false;
        }
        if (max != null && val >= max){
            return false;
        }
        if (!isValid(root.right,max, val)){
            return false;
        }
        if (!isValid(root.left, val, min)){
            return false;
        }
        return true;
    }

    public static boolean anotherIsValidBST(TreeNode root){
        if (root == null){
            return true;
        }
        if (!anotherIsValidBST(root.left)){
            return false;
        }
        if (pre != null && pre.val >= root.val){
            return false;
        }
        pre = root;
        if (!anotherIsValidBST(root.right)){
            return false;
        }
        return true;
    }


}

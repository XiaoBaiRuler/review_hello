package tree;

import java.util.HashMap;

/**
 * @Author xiaobai
 * @Date 2021/1/6 20:28
 * @Version 1.0
 */
public class Tree_07 {
    public static void main(String[] args) {

    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        int all = inorder.length;
        if (all == 0){
            return null;
        }
        int i = 0;
        for (; i < all; i++) {
            if (inorder[i] == postorder[all - 1]){
                break;
            }
        }
        // 记录postorder的索引
        HashMap<Integer, Integer> hashMap = new HashMap<>(16);
        for (int j = 0; j < all; j++) {
            hashMap.put(postorder[j], j);
        }
        TreeNode root = new TreeNode(postorder[all - 1], null, null);
        build(inorder, hashMap, 0, i - 1, i + 1, all - 1, root);
        return root;
    }

    public static void build(int[] inorder, HashMap<Integer, Integer> hashMap, int i, int j, int m, int n, TreeNode root){
        if (i == j){
            root.left = new TreeNode(inorder[i], null, null);
        }
        // 如何找出下一次缩小的范围？
        else{

        }
        if (m == n){
            root.right = new TreeNode(inorder[m], null, null);
        }
        else{

        }
    }
}

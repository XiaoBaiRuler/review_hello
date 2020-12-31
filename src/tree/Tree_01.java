package tree;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Author xiaobai
 * @Date 2020/12/29 10:41
 * @Version 1.0
 */
public class Tree_01 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, null);
        LearnBinaryTree.buildACompleteBinaryTree(root, 3);
        System.out.println(maxDepth(root));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        ArrayList<TreeNode> nowItems = new ArrayList<>();
        nowItems.add(root);
        int j = 0;
        int all = 0;
        while ((j = nowItems.size()) != 0){
            Iterator<TreeNode> it = nowItems.iterator();
            ArrayList<TreeNode> now = new ArrayList<>();
            while (it.hasNext()){
                TreeNode item = (TreeNode) it.next();
                if (item.left != null){
                    now.add(item.left);
                }
                if (item.right != null){
                    now.add(item.right);
                }
            }
            nowItems = now;
            all ++;
        }
        return all;
    }
}

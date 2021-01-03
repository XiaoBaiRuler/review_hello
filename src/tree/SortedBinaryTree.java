package tree;

/**
 * @Author xiaobai
 * @Date 2021/1/2 23:57
 * @Version 1.0
 */
public class SortedBinaryTree {
    public static void main(String[] args) {
        int[] all = {-1, -2, 4, -3, 4, 5, 6, 6};
        TreeNode root = null;
        for (int i = 0; i < all.length; i++) {
            root = insert(all[i], root);
        }
        for (int i = 0; i < all.length; i++) {
            root = remove(all[i], root);
        }
        root = insert(1, root);
        root = remove(0, root);
        System.out.println(root);
    }

    /**
     * 二叉排序树的添加
     * @param x x
     * @param root root
     * @return root
     */
    public static TreeNode insert(int x, TreeNode root){
        TreeNode p = root;
        if (p == null){
            return new TreeNode(x, null, null);
        }
        if (x > p.val){
            p.right = insert(x, p.right);
        }
        else if (x < p.val){
            p.left = insert(x, p.left);
        }
        return root;
    }

    /**
     * 二叉查找树的删除操作
     * @param x x
     * @param root root
     * @return root
     */
    public static TreeNode remove(int x, TreeNode root){
        if (root == null){
            return null;
        }
        if (x > root.val){
            root.right = remove(x, root.right);
        }
        else if (x < root.val){
            root.left = remove(x, root.left);
        }
        else{
            // 左右子树都不存在
            if (root.left == null && root.right == null){
                root = null;
            }
            // 有左子树, 将该节点和该节点的左子树的最右节点的值替换
            else if (root.right == null){
                TreeNode p = root.left;
                while (p.right != null){
                    p = p.right;
                }
                root.val = p.val;
                // 再删除左子树的该节点的值的节点
                root.left = remove(root.val, root.left);
            }
            // 有右子树，将该节点和该节点的右子树的最左节点的值替换
            else{
                TreeNode p = root.right;
                while (p.left != null){
                    p = p.left;
                }
                root.val = p.val;
                // 再删除右子树的该节点的值的节点
                root.right = remove(root.val, root.right);
            }
        }
        return root;
    }
}

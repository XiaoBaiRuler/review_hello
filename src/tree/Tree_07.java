package tree;

/**
 * 中序 + 后续构造二叉树
 * @Author xiaobai
 * @Date 2021/1/6 20:28
 * @Version 1.0
 */
public class Tree_07 {
    public static void main(String[] args) {
        int[] inorder = {-1};
        int[] postorder = {-1};
        TreeNode root = buildTree(inorder, postorder);
        LearnBinaryTree.breadthFirstSearch(root);
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        int all = inorder.length - 1;
        TreeNode root = build(inorder, 0, all, postorder, 0,  all);
        return root;
    }

    public static TreeNode build(int[] inorder,int inBegin, int inEnd, int[] postorder, int poBegin, int poEnd){
        if (inBegin > inEnd || poBegin > poEnd){
            return null;
        }
        TreeNode node = new TreeNode(postorder[poEnd]);
        for (int i = inBegin; i <= inEnd ; i++) {
            if (inorder[i] == postorder[poEnd]){
                node.left = build(inorder, inBegin, i - 1, postorder, poBegin, poBegin + i - inBegin - 1);
                node.right = build(inorder, i + 1, inEnd, postorder, poBegin + i - inBegin, poEnd - 1);
            }
        }
        return node;
    }
}

package tree;

/**
 * @Author xiaobai
 * @Date 2021/1/19 18:12
 * @Version 1.0
 */
public class Tree_08 {
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode root = buildTree(preorder, inorder);
        LearnBinaryTree.breadthFirstSearch(root);
    }
    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public static TreeNode build(int[] preorder, int[] inorder, int prBegin, int prEnd, int inBegin, int inEnd){
        if (prBegin > prEnd || inBegin > inEnd){
            return null;
        }
        int item = preorder[prBegin];
        TreeNode node = new TreeNode(item);
        for (int i = inBegin; i <= inEnd ; i++) {
            if (inorder[i] == item){
                node.left = build(preorder, inorder, prBegin + 1, prBegin + i - inBegin, inBegin, i - 1);
                node.right = build(preorder, inorder,prBegin + i - inBegin + 1, prEnd, i + 1, inEnd);
            }
        }
        return node;
    }
}

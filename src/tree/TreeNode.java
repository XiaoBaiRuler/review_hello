package tree;

/**
 * @Author xiaobai
 * @Date 2020/12/29 10:41
 * @Version 1.0
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(){

    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        //根节点->先读取所有左节点，再读取所有的右节点
        String x = " " + val;
        if (left != null){
            x += left.toString();
        }
        if (right != null){
            x += right.toString();
        }
        return x;
    }
}

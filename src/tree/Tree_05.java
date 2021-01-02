package tree;

/**
 * @Author xiaobai
 * @Date 2020/12/31 16:47
 * @Version 1.0
 */
public class Tree_05 {
    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        System.out.println(sortedArrayToBST(nums));
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return insertList(nums, 0, nums.length - 1);
    }

    /**
     * 递归，取中间点进行分配
     * @param nums nums
     * @param x x
     * @param y y
     * @return tree
     */
    public static TreeNode insertList(int[] nums, int x, int y){
        if (x > y){
            return null;
        }
        int all = x + (y - x) / 2;
        TreeNode node = new TreeNode(nums[all]);
        node.left = insertList(nums, x, all - 1);
        node.right = insertList(nums, all + 1, y);
        return node;
    }


    public static boolean insertTreeNode(TreeNode root, int x){
        TreeNode node = root;
        TreeNode item = null;
        while (node != null){
            if (node.val == x){
                return false;
            }
            item = node;
            if (node.val < x){
                node = node.right;
            }
            else{
                node = node.left;
            }
        }
        if (item == null){
            root = new TreeNode(x, null, null);
        }
        else if (x < item.val){
            item.left = new TreeNode(x, null, null);
        }
        else{
            item.right = new TreeNode(x, null, null);
        }
        return true;
    }
}

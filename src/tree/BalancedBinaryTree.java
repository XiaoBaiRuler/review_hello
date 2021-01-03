package tree;

/**
 * @Author xiaobai
 * @Date 2021/1/2 23:56
 * @Version 1.0
 */
public class BalancedBinaryTree {
    public static void main(String[] args) {
        int[] all = {1, 2, 3, 4, 5, 6};
        AVLNode root = null;
        for (int i = 0; i < all.length; i++) {
            root = insert(all[i], root);
        }
        for (int i = 5; i < all.length; i++) {
            root = remove(all[i], root);
        }
        System.out.println(root);
    }

    /**
     * 求节点的高度
     * @param p p
     * @return int
     */
    public static int height(AVLNode p){
        return p == null ? -1 : p.height;
    }

    /**
     * LL: 右旋
     * @param x x
     * @return w
     */
    private static AVLNode singleRotateRight(AVLNode x){
        //1. 把w节点代替x.left
        AVLNode w = x.left;
        //2. 同时w的右子树变为x的左子树
        x.left = w.right;
        //3. x变为w的右子树
        w.right = x;
        //4. 重新计算x/w的高度
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        w.height = Math.max(height(w.left), x.height) + 1;
        //5. 返回w
        return w;
    }

    /**
     * RR: 左旋
     * @param x x
     * @return w
     */
    private static AVLNode singleRotateLeft(AVLNode x){
        //1. 把w节点代替x.right
        AVLNode w = x.right;
        //2. 同时w的左子树变为x的右子树
        x.right = w.left;
        //3. x变为w的左子树
        w.left = x;
        //4. 重新计算x/w的高度
        w.height = Math.max(height(w.left), x.height) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        //5. 返回w
        return w;
    }

    /**
     * LR: 先左旋x.left再右旋x
     * @param x x
     * @return x
     */
    private static AVLNode doubleRotateLeftRight(AVLNode x){
        //x.left左旋
        x.left = singleRotateLeft(x.left);
        //x右旋
        return singleRotateRight(x);
    }

    /**
     * RL: 先右旋x.right再左旋x
     * @param x x
     * @return x
     */
    private static AVLNode doubleRotateRightLeft(AVLNode x){
        //1. 先右旋x.right
        x.right = singleRotateRight(x.right);
        //2. 左旋x
        return singleRotateLeft(x);
    }

    /**
     * 平衡二叉树的添加操作
     * @param x int
     * @param root root
     * @return root
     */
    public static AVLNode insert(int x, AVLNode root){
        AVLNode p = root;
        // 空树
        if (p == null){
            p = new AVLNode(x);
        }
        // 当x比p.data大时，向右子树寻找插入位置
        if (x > p.data){
            p.right = insert(x, p.right);
            // 判断插入点为左或右孩子？
            if (height(p.right) - height(p.left) == 2){
                //RL
                if (x < p.data){
                    //右左旋转
                    p = doubleRotateRightLeft(p);
                }
                //RR
                else{
                    //左旋转
                    p = singleRotateLeft(p);
                }
            }
        }
        // 当x比p.data小时，向左子树寻找插入位置
        else if (x < p.data){
            p.left = insert(x, p.left);
            // 判断插入点为左或右孩子？
            if (height(p.right) - height(p.left) == 2){
                //LR
                if (x > p.data){
                    //左右旋转
                    p = doubleRotateLeftRight(p);
                }
                //LL
                else{
                    //右旋转
                    p = singleRotateRight(p);
                }
            }
        }
        // 已经存在，就不用添加了

        // 重新计算各个节点的高度
        p.height = Math.max(height(p.left), height(p.right)) + 1;
        // 返回根节点
        return p;
    }

    /**
     * 删除==x的节点
     * @param x x
     * @param root root
     * @return root
     */
    public static AVLNode remove(int x, AVLNode root){
        if (root == null){
            return null;
        }
        //从左子树查找需要删除的元素
        if (x < root.data){
            root.left = remove(x, root.left);
            //检测是否平衡
            if (height(root.right) - height(root.left) == 2){
                AVLNode current = root.right;
                //判断需要那种旋转恢复
                if (height(current.left) > height(current.right)){
                    //RL: 右左旋转
                    root = doubleRotateRightLeft(root);
                }
                else{
                    //RR: 左旋转
                    root = singleRotateLeft(root);
                }
            }
        }
        // 从右子树查找需要删除的元素
        else if (x > root.data){
            root.right = remove(x, root.right);
            //检测是否平衡
            if (height(root.left) - height(root.right) == 2){
                AVLNode current = root.left;
                //LR: 左右旋转
                if (height(current.right) > height(current.left)){
                    root = doubleRotateLeftRight(root);
                }
                //LL: 右旋转
                else{
                    root = singleRotateRight(root);
                }
            }
        }
        // 找到删除节点，但是该节点同时拥有两个子节点
        else if (root.right != null && root.left != null){
            // 寻找替换节点: 最小值节点
            root.data = findMin(root.right).data;
            // 移除用于替换的节点
            root.right = remove(root.data, root.right);
        }
        // 只有一个节点或者只是叶子节点的情况
        else{
            root = (root.left != null) ? root.left : root.right;
        }
        //更新高度值
        if (root != null){
            root.height = Math.max(height(root.left), height(root.right)) + 1;
        }
        return root;
    }

    /**
     * 寻找最小值节点
     * @param right right
     * @return AVLNode
     */
    private static AVLNode findMin(AVLNode right) {
        if (right == null){
            return null;
        }
        else if (right.left == null){
            return right;
        }
        return findMin(right.left);
    }

}

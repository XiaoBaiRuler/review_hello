package tree;

/**
 * @Author xiaobai
 * @Date 2021/1/3 9:08
 * @Version 1.0
 */
public class AVLNode {
    public AVLNode left;
    public AVLNode right;
    public int data;
    public int height;

    public AVLNode(int data) {
        this.data = data;
    }

    public AVLNode(AVLNode left, AVLNode right, int data) {
        this.left = left;
        this.right = right;
        this.data = data;
        this.height = 0;
    }

    public AVLNode(AVLNode left, AVLNode right, int data, int height) {
        this.left = left;
        this.right = right;
        this.data = data;
        this.height = height;
    }
}

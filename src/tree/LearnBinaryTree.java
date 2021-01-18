package tree;

import java.util.*;

/**
 * @Author xiaobai
 * @Date 2020/12/30 8:03
 * @Version 1.0
 */
public class LearnBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, null);
        buildACompleteBinaryTree(root, 3);
        preorderTraversal(root);
        System.out.println(preorderTraversalByMorris(root));
        inOrderTraversal(root);
        System.out.println(inorderTraversalByMirrors(root));
        subsequentTraversal(root);
        System.out.println(subsequentTraversalByMirrors(root));
        subsequentTraversalByStack(root);
    }

    /**
     * 当前节点不为空，往当前节点插入节点作为左子树的父节点
     * @param root root
     * @param x x
     */
    public static TreeNode insertLeftNode(TreeNode root, int x){
        if (root == null){
            return null;
        }
        TreeNode item = root.left;
        root.left = new TreeNode(x, item, null);
        return root.left;
    }

    /**
     * 当前节点不为空，往当前节点插入节点作为右子树的父节点
     * @param root root
     * @param y y
     */
    public static TreeNode insertRightNode(TreeNode root, int y){
        if (root == null){
            return null;
        }
        TreeNode item = root.right;
        root.right = new TreeNode(y, null, item);
        return root.right;
    }

    /**
     * 按层次添加二叉树节点:满二叉树
     * @param root root
     * @param n 层次
     * @return root
     */
    public static TreeNode buildACompleteBinaryTree(TreeNode root, int n){
        ArrayList<TreeNode> items = new ArrayList<>();
        if (root == null){
            root = new TreeNode(1, null, null);
        }
        items.add(root);
        for (int i = 1; i <= n; i++) {
            items = buildALevelNode(items, (int) Math.pow(2, i));
        }
        return root;
    }

    /**
     * 给第几层添加节点:满二叉树
     * @param items 前一层节点列表
     * @param j 第几层
     * @return 当前层的节点列表
     */
    public static ArrayList<TreeNode> buildALevelNode(ArrayList<TreeNode> items, int j){
        int all = items.size();
        ArrayList<TreeNode> newItems = new ArrayList<>();
        for (int i = 0; i < all; i++) {
            newItems.add(insertLeftNode(items.get(i), j ++));
            newItems.add(insertRightNode(items.get(i), j ++));
        }
        return newItems;
    }

    /**
     * 递归:先序遍历二叉树
     * 时间复杂度: O(N)
     * 空间复杂度: O(logN) - O(N):最坏情况下为链状树
     * @param root root
     */
    public static void preorderTraversal(TreeNode root){
        if (root == null){
            return;
        }
        System.out.print(root.val + " ");
        if (root.left != null){
            preorderTraversal(root.left);
        }
        if (root.right != null){
            preorderTraversal(root.right);
        }
    }

    /**
     * 深度优先搜索好像一致,先序
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     * @param node root
     * @return lists
     */
    public static ArrayList<Integer> preorderTraversalByDFS(TreeNode node){
        ArrayList<Integer> list = new ArrayList<>();
        if (node == null){
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()){
            TreeNode item = stack.pop();
            list.add(item.val);
            if (item.right != null){
                stack.push(item.right);
            }
            if (item.left != null){
                stack.push(item.left);
            }
        }
        return list;
    }

    /**
     * 迭代: 先序遍历二叉树，和深度优先搜索好像一致，每个节点恰好被遍历一次
     * @param root root
     * @return lists
     */
    public static List<Integer> preorderTraversalByCycle(TreeNode root){
        List<Integer> lists = new ArrayList<>();
        if (root == null){
            return lists;
        }
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root != null){
            while (root != null){
                lists.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return lists;
    }

    /**
     * morris: 先序遍历: 如果两次达到某个节点，就打印第一次；如果一次就打印一次
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     * @param root root
     * @return list
     */
    public static List<Integer> preorderTraversalByMorris(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        TreeNode current = root;
        TreeNode mostRight = null;
        while (current != null){
            //左子树上最右的节点
            mostRight = current.left;
            if (mostRight != null){
                while (mostRight.right != null && mostRight.right != current){
                    mostRight = mostRight.right;
                }
                // 第一次到达左子树
                if (mostRight.right == null){
                    list.add(current.val);
                    mostRight.right = current;
                    current = current.left;
                    continue;
                }
                else{
                    mostRight.right = null;
                }
            }
            // 没有左子树
            else{
                list.add(current.val);
            }
            current = current.right;
        }
        return list;
    }

    /**
     * 递归:中序遍历二叉树
     * @param root root
     */
    public static void inOrderTraversal(TreeNode root){
        if (root.left != null){
            inOrderTraversal(root.left);
        }
        System.out.print(root.val + " ");
        if (root.right != null){
            inOrderTraversal(root.right);
        }
    }

    /**
     * morris: 中序遍历，如果两次达到某个节点，就打印第二次；如果一次就打印一次
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     * @param root root
     * @return list
     */
    public static List<Integer> inorderTraversalByMirrors(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        TreeNode current = root;
        TreeNode mostRight = null;
        while (current != null){
            mostRight = current.left;
            if (mostRight != null){
                while (mostRight.right != null && mostRight.right != current){
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null){
                    mostRight.right = current;
                    current = current.left;
                    // 跳到下一个循环
                    continue;
                }
                else{
                    mostRight.right = null;
                }
            }
            list.add(current.val);
            current = current.right;
        }
        return list;
    }

    /**
     * 递归:后续遍历二叉树
     * @param root root
     */
    public static void subsequentTraversal(TreeNode root){
        if (root == null){
            return;
        }
        subsequentTraversal(root.left);
        subsequentTraversal(root.right);
        System.out.print(root.val + " ");
    }

    /**
     * 借助堆栈的后续遍历二叉树
     * 1. 如果栈顶元素非空且左节点存在，将其入栈，若不存在则进入下一步
     * 2. 判断上一次出栈节点是否当前节点的右节点，或者当前节点是否存在右节点
     * 3. 如果以上条件满足，将当前节点出栈输出；否则将右节点压栈，跳到1.
     *
     * @param root root
     */
    public static void subsequentTraversalByStack(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode lastNode = null;
        while (!stack.isEmpty()){
            // 到达最左端的叶子节点
            while (stack.peek().left != null){
                stack.push(stack.peek().left);
            }
            while (!stack.isEmpty()){
                // lastNode == stack.peek().right: 证明已经访问过右节点，可以输出根节点了
                if ((lastNode == stack.peek().right) || stack.peek().right == null){
                    TreeNode node = stack.pop();
                    System.out.print(node.val + " ");
                    lastNode = node;
                }
                // 访问右节点
                else if (stack.peek().right != null){
                    stack.push(stack.peek().right);
                    break;
                }
            }
        }
    }

    /**
     * morris的后续遍历，不建议使用
     * @param root root
     * @return lists
     */
    public static List<Integer> subsequentTraversalByMirrors(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        TreeNode current = root;
        TreeNode mostRight = null;
        while (current != null){
            mostRight = current.left;
            if (mostRight != null){
                while (mostRight.right != null && mostRight.right != current){
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null){
                    mostRight.right = current;
                    current = current.left;
                    continue;
                }
                else{
                    mostRight.right = null;
                    list.addAll(printRightEdge(current.left));
                }
            }
            current = current.right;
        }
        list.addAll(printRightEdge(root));
        return list;
    }

    /**
     * 逆序右边界，等同于单链表的逆序
     * @param node node
     * @return TreeNode
     */
    public static TreeNode reverseEdge(TreeNode node){
        TreeNode pre = null;
        TreeNode next = null;
        while (node != null){
            next = node.right;
            node.right = pre;
            pre = node;
            node = next;
        }
        return pre;
    }

    /**
     * 逆序打印以head为头节点的右边界
     * @param head head
     * @return list
     */
    public static List<Integer> printRightEdge(TreeNode head){
        List<Integer> list = new ArrayList<>();
        TreeNode tai = reverseEdge(head);
        TreeNode cur = tai;
        while (cur != null){
            list.add(cur.val);
            cur = cur.right;
        }
        reverseEdge(tai);
        return list;
    }

    /**
     * 深度优先搜索: 使用堆栈
     * @param root root
     */
    public static void depthFirstSearch(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode item = stack.pop();
            System.out.print(item.val + " ");
            if (item.right != null){
                stack.push(item.right);
            }
            if (item.left != null){
                stack.push(item.left);
            }
        }
    }

    /**
     * 广度优先遍历: 使用队列
     * @param root root
     */
    public static void breadthFirstSearch(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode item = queue.remove();
            System.out.print(item.val + " ");
            if (item.left != null){
                queue.add(item.left);
            }
            if (item.right != null){
                queue.add(item.right);
            }
        }
    }

    /**
     * Morris遍历: 充分利用树的指向null的指针，来节省空间
     * 原则:
     * 1. 设current为当前节点
     * 2. 若current没有左子树，current = current.right
     * 3. 若current有左子树， 找出左子树的最右节点mostRight
     * 3. 1. 若mostRight == null, mostRight = current, current = current.left
     * 3. 2. 若mostRight == current, mostRight = null, current = current.right
     * 4. 若current == null停止
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     * @param root root
     */
    public static void morris(TreeNode root){
        if (root == null){
            return;
        }
        TreeNode current = root;
        TreeNode mostRight = null;
        // current为空时遍历停止
        while (current != null){
            // 当前节点的左子树
            mostRight = current.left;
            // 当前节点的左子树的最右节点
            if (mostRight != null){
                // mostRight.right
                while (mostRight.right != null && mostRight.right != current){
                    mostRight = mostRight.right;
                }
                // mostRight.right == null, mostRight.right = current, current左移动
                if (mostRight.right == null){
                    mostRight.right = current;
                    current = current.left;
                    continue;
                }
                // mostRight.right == current, mostRight.right = null
                else{
                    mostRight.right = null;
                }
            }
            // 没有左子树或mostRight.right == current, current右移动
            current = current.right;
        }
    }
}

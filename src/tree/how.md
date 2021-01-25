#### 106. 从中序与后序遍历序列构造二叉树

> [题目描述](https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal)
>
> > 根据一棵树的中序遍历与后序遍历构造二叉树。 
> > 注意:
> > 你可以假设树中没有重复的元素。 
> > 例如，给出 
> > 中序遍历 inorder = [9,3,15,20,7]
> > 后序遍历 postorder = [9,15,7,20,3]
> > 返回如下的二叉树的root
>
> **解题思路1.** : 按照后序列表找到根节点 - 再根据根节点值和中序列表找来区分左右子树的中序和后序列表 - 不断迭代直到后序或中序列表不存在时
>
> > 1. 中序列表和后序列表会更新变化，怎样更新变化？
> >
> >    > 通过新建两个新的列表：要复制数组，资源浪费严重，放弃
> >    > 通过索引记录下一次中序和后序列表的索引：可以，那么开始为中序:(0, in.length - 1)后序:(0, po.length - 1)，统一设为中序:(inBegin, inEnd)后序:(poBegin, poEnd)
> >
> > 2. 迭代停止是在后序列表或中序列表不存在时，如何表达？
> >
> >    > 中序和后序列表的索引的开始比结束大时，结束
> >
> > 3. **在区分左右子树的时候是用索引，那么新的索引又是多少？** 注意:左子树的右子树，右子树的左子树
> >
> >    > 先找到中序列表的根节点的索引: i，**(i - inBegin)是代表中序列表经过多少个才找到根节点**
> >    > 左子树：中序:(inBegin, i - 1)后序:(poBegin, poBegin + (i - inBegin) - 1)
> >    > 右子树：中序:(i + 1, inEnd)后序:(poBegin + (i - inBegin), poEnd - 1)
>
> [代码](Tree_07.java)

#### 105. 从前序与中序遍历序列构造二叉树

> [题目描述](https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)
>
> > 根据一棵树的前序遍历与中序遍历构造二叉树。
> > 注意:你可以假设树中没有重复的元素。
> >
> > 例如，给出
> >
> > 前序遍历 preorder = [3,9,20,15,7]
> > 中序遍历 inorder = [9,3,15,20,7]
>
> **解题思路1.**:按照前序列表找到根节点 - 再根据根节点值和中序列表找来区分左右子树的前序和中序列表 - 不断迭代直到前序或中序列表不存在时
>
> > 和106的中序后序构造二叉树的相似，也用索引来代表新的中序和前序列表，设中序列表根节点的索引为i，列表统一设为前序:(prBegin, prEnd)和中序:(inBegin, inEnd)，那么新的左右子树的索引为:
> >
> > 左子树：前序: (prBegin + 1, prBegin + (i - inBegin))中序:(inBegin, i - 1)
> > 右子树：前序:(prBegin + (i - inBegin) + 1, prEnd)中序：(i + 1, inEnd)
>
> [代码](Tree_08.java)

#### 116. 填充每个节点的下一个右侧节点指针

>  [题目描述](https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/)
>
> > 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
> >
> > struct Node {
> >   int val;
> >   Node *left;
> >   Node *right;
> >   Node *next;
> > }
> > 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
> >
> > 初始状态下，所有 next 指针都被设置为 NULL。
> >
> > 进阶：
> >
> > 你只能使用常量级额外空间。
> > 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
>
> **解题思路1.**:可以采用广度优先搜索(修改一下每次迭代一层的队列)，然后将给队列中的每个元素设定next
>
> [代码](Tree_09.java)

#### 117. 填充每个节点的下一个右侧节点指针 II

> [题目描述](https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/)
>
> > 给定一个二叉树
> >
> > struct Node {
> >   int val;
> >   Node *left;
> >   Node *right;
> >   Node *next;
> > }
> > 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
> >
> > 初始状态下，所有 next 指针都被设置为 NULL。
> >
> > 进阶：
> >
> > 你只能使用常量级额外空间。
> > 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
>
> **解题思路1:**：好像上一题的解题思路也没有问题
>
> [代码](Tree_09.java) 
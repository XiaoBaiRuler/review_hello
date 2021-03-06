#### [349. 两个数组的交集](https://leetcode-cn.com/problems/intersection-of-two-arrays/)

> 给定两个数组，编写一个函数来计算它们的交集
>
> ```java
> 输入：nums1 = [1,2,2,1], nums2 = [2,2]
> 输出：[2]
> ```
>
> **解题思路**：第一个数组通过读入HashSet，第二个数组遍历每个元素，判断是否在哈希表中，如果在就将值赋值给第一个数组(索引重计算)，然后删除HashSet中的该元素
>
> [代码](Hash_01.java)

#### [202. 快乐数](https://leetcode-cn.com/problems/happy-number/)

> 编写一个算法来判断一个数 n 是不是快乐数。
>
> 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
>
> 如果 n 是快乐数就返回 True ；不是，则返回 False 。
>
> **解题思路**：不断计算每个位置上的数字的平方和，通过hash表判断，如果出现重复，就可能无限循环，如果出现值为1，循环结束，是快乐数
>
> [代码](Hash_02.java)

#### [771. 宝石与石头](https://leetcode-cn.com/problems/jewels-and-stones/)

>  给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
>
> J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
>
> 解题思路1：hash
>
> [代码](Hash_04.java)

#### [205. 同构字符串](https://leetcode-cn.com/problems/isomorphic-strings/)

> 给定两个字符串 s 和 t，判断它们是否是同构的。
>
> 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
>
> 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
>
> 解题思路1：根据同构性质排除 + 包含优化的(判断 s*s* 和 t*t* 每个位置上的字符是否都一一对应，即 s*s* 的任意一个字符被 t*t* 中唯一的字符对应，同时 t*t* 的任意一个字符被 s*s* 中唯一的字符对应)
>
> [代码](Hash_03.java)

#### [599. 两个列表的最小索引总和](https://leetcode-cn.com/problems/minimum-index-sum-of-two-lists/)

> 假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
>
> 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设总是存在一个答案。
>
> 解题思路1：hash表进行比对(穷举法吧)，算法不好：停止时会有多余操作
>
> [代码](Hash_05.java)
>
> 解题思路2：直接两次遍历，使用HashMap
>
> [代码](Hash_05.java)
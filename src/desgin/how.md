#### [384. 打乱数组](https://leetcode-cn.com/problems/shuffle-an-array/)

> 给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。
>
> 实现 Solution class:
>
> Solution(int[] nums) 使用整数数组 nums 初始化对象
> int[] reset() 重设数组到它的初始状态并返回
> int[] shuffle() 返回数组随机打乱后的结果
>
> 解题思路1: 为了保证同概率，随机数种子要一作为全局变量：每次i - nums.length获取一个随机整数作为索引，然后和i和随机整数索引下的元素交换；再重复之前步骤，直到最后
>
> [代码](Design_01.java)
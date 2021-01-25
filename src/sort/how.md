#### [88. 合并两个有序数组](https://leetcode-cn.com/problems/merge-sorted-array/)

> 你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
>
> 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
>
> **解题思路1**：插入排序
>
> [代码](Sort_01.java)
>
> 解题思路2：由于已经排好序了，可以使用双指针，两个数组的实际位置从后往前找，比较大小，找到就放置在数组nums1的最后位置
>
> [代码](Sort_01.java)
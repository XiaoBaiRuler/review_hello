package sort;

import java.util.Arrays;

/**
 * @Author xiaobai
 * @Date 2021/1/22 22:29
 * @Version 1.0
 */
public class LearnSort {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 9, 3};
        shellSort(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 插入排序
     * 假定前面1-p都是排好序的了，每躺都可能后面的后移挪位给插入的位置
     * 平均时间复杂度: O(N^2)
     *
     * @param a 数组
     */
    public static void insertionSort(int[] a){
        for (int p = 1; p < a.length; p++) {
            int temp = a[p];
            int i = p;
            for (; i > 0 && temp < a[i - 1]; i--) {
                a[i] = a[i - 1];
            }
            a[i] = temp;
        }
    }

    /**
     * 希尔排序
     * 为了解决插入排序中，本省i需要插入到i - p中，但是插入排序要一个一个比较，而希尔排序跨多个比较
     * 最好的间隔序列: [1, 5, 19, 41, 109], 9*4^i - 9*2^i + 1, 4^i - 3*2^i + 1
     * 使得数移动时能跨过多个元素，则进行一次比较就可能消除多个元素交换
     * @param a 数组
     */
    public static void shellSort(int[] a){
        for (int gap = a.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < a.length; i++) {
                int temp = a[i];
                int j = i;
                for (; j >= gap && temp < a[j - gap]; j -= gap) {
                    a[j] = a[j - gap];
                }
                a[j] = temp;
            }
        }
    }
}

package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author xiaobai
 * @Date 2021/1/22 22:29
 * @Version 1.0
 */
public class LearnSort {
    public static void main(String[] args) {
        String[] a = new String[10];
        for (int i = 0; i < 10; i++) {
            if (i / 3 != 0){
                a[i] = "abc";
            }
            else if (i / 2 != 0){
                a[i] = "ade";
            }
            else{
                a[i] = "ebc";
            }
        }
        stringRadixSort(a, 3);
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

    /**
     * 堆排序：大顶堆
     * 时间复杂度为O(NlogN)
     * 空间复杂度为N
     * @param a 数组
     */
    public static void heapSort(int[] a){
        for (int i = a.length / 2 - 1; i >= 0; i--) {
            perDown(a, i, a.length);
        }
        for (int i = a.length - 1; i > 0; i--) {
            swap(a, 0, i);

            perDown(a, 0, i);
        }
    }

    private static void swap(int[] a, int begin, int end) {
        int item = a[begin];
        a[begin] = a[end];
        a[end] = item;
    }

    /**
     * 下滤操作:
     * @param a 数组
     * @param i 根节点位置
     * @param length 数组长度
     */
    private static void perDown(int[] a, int i, int length) {
        int child;
        int tmp;
        for (tmp = a[i]; (2 * i + 1) < length; i = child) {
            child = 2 * i + 1;
            // 左孩子存在且左孩子比右孩子小时，跳到右孩子
            if (child != length - 1 && a[child] < a[child + 1]){
                child ++;
            }
            // 当根节点比右(左)孩子小时，将右(左)孩子转移上去： 目的是让最大值移到父节点
            if (tmp < a[child]){
                a[i] = a[child];
            }
            else{
                break;
            }
        }
        a[i] = tmp;
    }

    /**
     * 归并排序
     * 最坏时间复杂度O(NlogN)
     * 空间复杂度O(N)
     * @param a a
     */
    public static void mergeSort(int[] a){
        int[] tmpArray = new int[a.length];
        mergeSort(a, tmpArray, 0, a.length - 1);
    }

    private static void mergeSort(int[] a, int[] b, int left, int right){
        if (left < right){
            int center = (left + right) / 2;
            mergeSort(a, b, left, center);
            mergeSort(a, b, center + 1, right);
            merge(a, b, left, center + 1, right);
        }
    }

    /**
     * 合并两个有序列表到b
     * @param a a
     * @param b b
     * @param leftPos 第一个有序列表开始
     * @param rightPos 第二个有序列表开始
     * @param rightEnd 第二个有序列表结束
     */
    private static void merge(int[] a, int[] b, int leftPos, int rightPos, int rightEnd) {
        // 第一个有序列表结束
        int leftEnd = rightEnd - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;

        while (leftPos <= leftEnd && rightPos <= rightEnd){
            if (a[leftPos] <= a[rightPos]){
                b[tmpPos ++] = a[leftPos ++];
            }
            else{
                b[tmpPos ++] = a[rightPos ++];
            }
        }
        while (leftPos <= leftEnd){
            b[tmpPos ++] = a[leftPos ++];
        }
        while (rightPos <= rightEnd){
            b[tmpPos ++] = a[rightPos ++];
        }
        // 复制元素回原数组
        for (int i = 0; i < numElements; i++,rightEnd --) {
            a[rightEnd] = b[rightEnd];
        }
    }

    /**
     * 分治思想
     * @param item item
     */
    public static void quickSortSame(List<Integer>item){
        List<Integer> smaller = new ArrayList<>();
        List<Integer> same = new ArrayList<>();
        List<Integer> larger = new ArrayList<>();
        Integer chosenItem = item.get(item.size() / 2);
        for(Integer i : item){
            if (i < chosenItem){
                smaller.add(i);
            }
            else if (i > chosenItem){
                larger.add(i);
            }
            else{
                same.add(i);
            }
        }
        quickSortSame(smaller);
        quickSortSame(larger);

        item.clear();
        item.addAll(smaller);
        item.addAll(same);
        item.addAll(larger);
    }

    /**
     * 快速排序
     * @param a a
     */
    public static void quickSort(int[] a){
        quickSort(a, 0, a.length - 1);
    }
    private static void quickSort(int[] a, int left, int right){
        if (left + 20 <= right){
            int pivot = median3(a, left, right);
            int i = left + 1, j = right - 2;
            while (true){
                while (a[i] < pivot){
                    i ++;
                }
                while (a[j] > pivot){
                    j --;
                }
                if (i < j){
                    swap(a, i, j);
                }
                else{
                    break;
                }
            }
            // 放置枢纽元回正确位置
            swap(a, i, right - 1);
            quickSort(a, left, i - 1);
            quickSort(a, i + 1, right);
        }
        // 小数组采用插入排序
        else{
            insertionSort(a);
        }
    }

    /**
     * 选择枢纽元：三数中值法
     * @param a a
     * @param left left
     * @param right right
     * @return int
     */
    private static int median3(int[] a, int left, int right){
        int center = (left + right) / 2;
        if (a[center] < a[left]){
            swap(a, left, center);
        }
        if (a[right] < a[left]){
            swap(a, left, right);
        }
        if (a[right] < a[center]){
            swap(a, center, right);
        }
        // 枢纽元储存在right - 1位置上，提供一个警戒标记
        swap(a, center, right - 1);
        return a[right - 1];
    }

    /**
     * 桶排序
     * @param a a
     * @param M M
     */
    public static void bucketSort(int[] a, int M){
        int[] count = new int[M];
        for (int i = 0; i < a.length; i++) {
            count[a[i]] ++;
        }
        int j = 0;
        for (int i = 0; i < M; i++) {
            if (count[i] != 0){
                while (count[i] -- != 0){
                    a[j] = i;
                    j ++;
                }
            }
        }
    }

    /**
     * 基于计数的基数排序
     * @param a a
     * @param digit digit
     */
    public static void countRadixSort(int[] a, int digit){
        for (int i = 1; i <= digit; i++) {
            int[] tempArray = new int[a.length];
            int[] countArray = new int[10];
            // 多次进行桶排序
            for (int j = 0; j < a.length; j++) {
                int tmpSplitDigit = a[j] / (int)Math.pow(10, i - 1) - (a[j] / (int)Math.pow(10, i)) * 10;
                countArray[tmpSplitDigit] += 1;
            }
            for (int j = 1; j < 10; j++) {
                countArray[j] += countArray[j - 1];
            }
            // 还需额外O(N)的数组作为临行数组，缓存每次桶排序的数据
            for (int j = a.length - 1; j >= 0 ; j--) {
                int tempSplitDigit = a[j] / (int)Math.pow(10, i - 1) - (a[j] / (int)Math.pow(10, i)) * 10;
                tempArray[countArray[tempSplitDigit] - 1] = a[j];
                countArray[tempSplitDigit] -= 1;
            }
            for (int j = 0; j < a.length; j++) {
                a[j] = tempArray[j];
            }
        }
    }

    /**
     * stringLen长度的字符串的基数排序
     *
     * @param arr String[]
     * @param stringLen int
     */
    public static void stringRadixSort(String[] arr, int stringLen){
        final int BUCKETS = 256;
        ArrayList<String>[] buckets = new ArrayList[BUCKETS];
        for (int i = 0; i < BUCKETS; i++) {
            buckets[i] = new ArrayList<>();
        }
        for (int pos = stringLen - 1; pos >= 0; pos --) {
            for (String s: arr){
                buckets[s.charAt(pos)].add(s);
            }
            int idx = 0;
            for (ArrayList<String> thisBucket : buckets){
                for (String s: thisBucket) {
                    arr[idx++] = s;
                }
                thisBucket.clear();
            }
        }
    }
}

package queue;

import java.nio.BufferUnderflowException;

/**
 * @Author xiaobai
 * @Date 2021/1/24 9:45
 * @Version 1.0
 */
public class BinaryHeap <AnyType extends Comparable<? super AnyType>>{

    private static final int DEFAULT_CAPACITY = 10;
    private int currentSize;
    private AnyType[] array;

    public BinaryHeap() {
        array = (AnyType[]) new Comparable[DEFAULT_CAPACITY];
    }

    public BinaryHeap(int Capacity) {
        array = (AnyType[]) new Comparable[Capacity];
    }

    public BinaryHeap(AnyType[] items) {
        currentSize = items.length;
        array = (AnyType[]) new Comparable[(currentSize + 2) * 11 / 10];
        for (int j = 0; j < currentSize; j++) {
            array[j + 1] = items[j];
        }
        buildHeap();
    }

    /**
     * 在下一个位置创建一个空穴，通过上滤操作: 将新的最小值向上放置
     * @param x x
     */
    public void insert(AnyType x){
        // 扩大数组
        if (currentSize == array.length - 1){
            enlargeArray(array.length * 2 - 1);
        }
        // 0位置作为新插入位置的空穴
        int hole = ++currentSize;
        for (array[0] = x; x.compareTo(array[hole / 2]) < 0; hole /= 2){
            array[hole] = array[hole / 2];
        }
        array[hole] = x;
    }

    public AnyType findMin(){
        return array[1];
    }

    public AnyType deleteMin(){
        if (isEmpty()){
            throw new BufferUnderflowException();
        }
        AnyType minItem = findMin();
        array[1] = array[currentSize--];
        percolateDown(1);
        return minItem;
    }

    public boolean isEmpty(){
        return currentSize == 0;
    }

    public void makeEmpty(){
        currentSize = 0;
    }

    /**
     * 将index=1变为空穴，通过下滤操作：将最小值删除，并将最新的最小值放在根节点位置
     * @param hole hole
     */
    private void percolateDown(int hole){
        int child = hole * 2;
        AnyType temp = array[hole];
        for (; hole * 2 <= currentSize; hole = child) {
            child = hole * 2;
            // 右节点
            if (child != currentSize && array[child + 1].compareTo(array[child]) < 0){
                child ++;
            }
            // 左节点
            if (array[child].compareTo(temp) < 0){
                array[hole] = array[child];
            }
            else{
                break;
            }
        }
        array[hole] = temp;
    }

    /**
     * 对每个根节点进行下滤操作：将数组装为二叉树
     */
    private void buildHeap(){
        for (int i = currentSize / 2; i > 0; i--) {
            percolateDown(i);
        }
    }

    private void enlargeArray(int newSize) {
        AnyType[] items = array;
        array = (AnyType[]) new Comparable[newSize];
        for (int i = 0; i < items.length; i++) {
            array[i] = items[i];
        }
    }
}

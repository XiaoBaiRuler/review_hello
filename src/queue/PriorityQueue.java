package queue;

/**
 * @Author xiaobai
 * @Date 2021/1/23 11:34
 * @Version 1.0
 */
public class PriorityQueue<AnyType extends Comparable<? super AnyType>> {

    private BinaryHeap<AnyType> binaryHeap;

    public PriorityQueue() {
        binaryHeap = new BinaryHeap<>();
    }

    public PriorityQueue(int capacity){
        binaryHeap = new BinaryHeap<>(capacity);
    }

    public PriorityQueue(AnyType[] array){
        binaryHeap = new BinaryHeap<>(array);
    }

    public void insert(AnyType x){
        binaryHeap.insert(x);
    }

    public AnyType findMin(){
        return binaryHeap.findMin();
    }

    public AnyType deleteMin(){
        return binaryHeap.deleteMin();
    }

    public boolean isEmpty(){
        return binaryHeap.isEmpty();
    }
}

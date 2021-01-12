package queue;

/**
 * tag == 0 && rear == front 为空
 * tag == 1 && rear == front 为满
 *
 * 优点: 可以满空间使用了，但是借助了额外的标志位
 * 缺点: 求余操作还是没有处理掉
 *
 * @Author xiaobai
 * @Date 2021/1/12 20:45
 * @Version 1.0
 */
public class CircularQueueByTag<AnyType> {
    private AnyType[] queue;
    private final static int MAX_QUEUE_SIZE = 10;
    private int rear;
    private int front;
    private int tag;

    public CircularQueueByTag(){
        this.queue = (AnyType[]) new Object[MAX_QUEUE_SIZE];
        this.rear = 0;
        this.front = 0;
        this.tag = 0;
    }

    public boolean isEmpty(){
        if (tag == 0 && rear == front){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isFull(){
        if (tag == 1 && rear == front){
            return true;
        }
        return false;
    }

    public boolean enqueue(AnyType data){
        if (isFull()){
            System.out.println("队列已经满了");
            return false;
        }
        queue[rear % MAX_QUEUE_SIZE] = data;
        rear ++;
        tag = 1;
        return true;
    }

    public AnyType dequeue() throws Exception {
        if (isEmpty()){
            throw new Exception("队列为空");
        }
        AnyType item = queue[front % MAX_QUEUE_SIZE];
        front ++;
        tag = 0;
        return item;
    }

    public AnyType getFront() throws Exception {
        if (front == rear){
            throw new Exception("队列为空");
        }
        return queue[front];
    }
}

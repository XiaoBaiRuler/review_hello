package queue;

/**
 * @Author xiaobai
 * @Date 2021/1/12 13:00
 * @Version 1.0
 */
public class SequentialQueue<AnyType> {
    private AnyType[] queue;
    private final static int MAX_QUEUE_SIZE = 10;
    private int rear;
    private int front;
    private int count;

    public SequentialQueue(){
        this.queue = (AnyType[]) new Object[MAX_QUEUE_SIZE];
        this.rear = 0;
        this.front = 0;
        this.count = 0;
    }

    public boolean isEmpty(){
        if (rear == front){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isFull(){
        if (rear == MAX_QUEUE_SIZE){
            return true;
        }
        return false;
    }

    public boolean enqueue(AnyType data){
        if (rear == MAX_QUEUE_SIZE){
            System.out.println("队列已经满了");
            return false;
        }
        queue[rear] = data;
        rear ++;
        count ++;
        return true;
    }

    public AnyType dequeue() throws Exception {
        if (front == rear){
            throw new Exception("队列为空");
        }
        AnyType item = queue[front];
        front ++;
        count --;
        return item;
    }

    public AnyType getFront() throws Exception {
        if (front == rear){
            throw new Exception("队列为空");
        }
        return queue[front];
    }

    public int getRealSize(){
        return count;
    }
}

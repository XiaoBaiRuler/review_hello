package queue;

/**
 * 借助空一个长度的数组，来达成区分空和满
 * 空: rear == front
 * 满: (rear + 1) % MAX_QUEUE_SIZE == front
 *
 * 不足，少了一个空间，并且索引和判断满都需要%操作，需要时间多
 *
 * @Author xiaobai
 * @Date 2021/1/12 13:44
 * @Version 1.0
 */
public class CircularQueueLessOne <AnyType>{
    private AnyType[] queue;
    private final static int MAX_QUEUE_SIZE = 10;
    private int rear;
    private int front;
    private int count;

    public CircularQueueLessOne(){
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
        // 少一个空格判断是否满
        // (rear + 1) - (rear + 1) / MAX_QUEUE_SIZE
        if ((rear + 1) % MAX_QUEUE_SIZE == front){
            return true;
        }
        return false;
    }

    public boolean enqueue(AnyType data){
        if (isFull()){
            System.out.println("队列已经满了");
            return false;
        }
        queue[rear % (MAX_QUEUE_SIZE - 1)] = data;
        rear ++;
        count ++;
        return true;
    }

    public AnyType dequeue() throws Exception {
        if (front == rear){
            throw new Exception("队列为空");
        }
        AnyType item = queue[front % (MAX_QUEUE_SIZE - 1)];
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

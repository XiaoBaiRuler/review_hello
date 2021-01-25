package queue;

/**
 * 空: count == 0
 * 满: count == MAX_QUERY_SIZE
 *
 * 优点: 额外知道具体使用了多少个空间
 * 缺点: %还是在
 *
 * @Author xiaobai
 * @Date 2021/1/12 13:14
 * @Version 1.0
 */
public class TestQueue {
    public static void main(String[] args) throws Exception {
//        CircularQueueLessOne<Integer> circularQueueLessOne = new CircularQueueLessOne<>();
//        for (int i = 0; i < 9; i++) {
//            circularQueueLessOne.enqueue(i + 1);
//        }
//        for (int i = 0; i < 4; i++) {
//            circularQueueLessOne.dequeue();
//            circularQueueLessOne.enqueue(11);
//        }
//        System.out.println(circularQueueLessOne.getRealSize());

//        CircularQueueByTag<Integer> circularQueueByTag = new CircularQueueByTag<>();
//        for (int i = 0; i < 10; i++) {
//            circularQueueByTag.enqueue(i + 1);
//        }
//        for (int i = 0; i < 4; i++) {
//            circularQueueByTag.dequeue();
//            circularQueueByTag.enqueue(11);
//        }
//        System.out.println(circularQueueByTag);


//        CircularQueueByCount<Integer> circularQueueByCount = new CircularQueueByCount<>();
//        for (int i = 0; i < 10; i++) {
//            circularQueueByCount.enqueue(i + 1);
//        }
//        for (int i = 0; i < 4; i++) {
//            circularQueueByCount.dequeue();
//            circularQueueByCount.enqueue(11);
//        }
//        System.out.println(circularQueueByCount.getQueueSize());

//        MyCircularQueue myCircularQueue = new MyCircularQueue(2);
//        myCircularQueue.enQueue(1);
//        myCircularQueue.enQueue(2);
//        myCircularQueue.deQueue();
//        myCircularQueue.enQueue(3);
//        myCircularQueue.deQueue();
//        myCircularQueue.enQueue(3);
//        myCircularQueue.deQueue();
//        myCircularQueue.enQueue(3);
//        myCircularQueue.deQueue();

        ComInte[] comIntes = new ComInte[6];
        for (int i = 0; i < 6; i++) {
            comIntes[i] = new ComInte(i);
        }
        PriorityQueue<ComInte> priorityQueue = new PriorityQueue<>(comIntes);
        System.out.println(priorityQueue.findMin().a);
        System.out.println(priorityQueue.deleteMin().a);
        System.out.println(priorityQueue.findMin().a);

    }
}

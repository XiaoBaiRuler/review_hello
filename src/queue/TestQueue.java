package queue;

/**
 * @Author xiaobai
 * @Date 2021/1/12 13:14
 * @Version 1.0
 */
public class TestQueue {
    public static void main(String[] args) throws Exception {
        CircularQueueLessOne<Integer> circularQueueLessOne = new CircularQueueLessOne<>();
        for (int i = 0; i < 9; i++) {
            circularQueueLessOne.enqueue(i + 1);
        }
        for (int i = 0; i < 4; i++) {
            circularQueueLessOne.dequeue();
            circularQueueLessOne.enqueue(11);
        }
        System.out.println(circularQueueLessOne.getRealSize());


    }
}

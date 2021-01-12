package queue;

/**
 * @Author xiaobai
 * @Date 2021/1/12 13:14
 * @Version 1.0
 */
public class TestQueue {
    public static void main(String[] args) throws Exception {
        SequentialQueue<Integer> sequentialQueue = new SequentialQueue<>();
        for (int i = 0; i < 10; i++) {
            sequentialQueue.enqueue(i + 1);
        }
        for (int i = 0; i < 10; i++) {
            sequentialQueue.dequeue();
        }
        System.out.println(sequentialQueue.getRealSize());
    }
}

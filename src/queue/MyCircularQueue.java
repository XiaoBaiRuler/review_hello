package queue;

/**
 * @Author xiaobai
 * @Date 2021/1/12 22:58
 * @Version 1.0
 */
class MyCircularQueue {

    private static int MAX_SIZE;
    private int[] data;
    private int rear;
    private int front;
    private int count;
    private int f;
    private int r;

    public MyCircularQueue(int k) {
        MAX_SIZE = k;
        this.data = new int[k];
        this.rear = 0;
        this.front = 0;
        this.count = 0;
        this.f = 0;
        this.r = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()){
            return false;
        }
        r = rear - rear / MAX_SIZE * MAX_SIZE;
        System.out.println(r + "" + rear);
        data[r] = value;
        rear ++;
        count ++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()){
            return false;
        }
        front ++;
        f = front - front / MAX_SIZE * MAX_SIZE;
        count --;
        return true;
    }

    public int Front() {
        if (isEmpty()){
            return -1;
        }
        return data[f];
    }

    public int Rear() {
        if (isEmpty()){
            return -1;
        }
        return data[r];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == MAX_SIZE;
    }
}

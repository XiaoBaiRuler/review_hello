package queue;

/**
 * @Author xiaobai
 * @Date 2021/1/25 9:53
 * @Version 1.0
 */
public class ComInte implements Comparable<ComInte>{
    public Integer a;

    public ComInte(Integer a) {
        this.a = a;
    }

    @Override
    public int compareTo(ComInte o) {
        return a.compareTo(o.a);
    }
}

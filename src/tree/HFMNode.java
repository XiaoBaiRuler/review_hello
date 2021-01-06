package tree;

/**
 * @Author xiaobai
 * @Date 2021/1/4 20:13
 * @Version 1.0
 */
public class HFMNode implements Comparable<HFMNode>{
    /**
     * 权值
     */
    public int weight;

    public String s;

    /**
     * 左孩子节点
     */
    public HFMNode left;
    /**
     * 右孩子节点
     */
    public HFMNode right;

    public HFMNode(int weight, String s, HFMNode left, HFMNode right) {
        this.weight = weight;
        this.s = s;
        this.left = left;
        this.right = right;
    }


    @Override
    public int compareTo(HFMNode o) {
        if (this.weight > o.weight){
            return 1;
        }
        if (this.weight < o.weight){
            return -1;
        }
        return 0;
    }
}

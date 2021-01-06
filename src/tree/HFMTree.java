package tree;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @Author xiaobai
 * @Date 2021/1/4 20:12
 * @Version 1.0
 */
public class HFMTree {

    // 1. 输入一个字符串，我要找到词频，并且记录到PriorityQueue中：一种优先队列，每次取出的元素都是最小值
    // 2. 取出两个节点作为左右节点，生成一个新节点(权值为这两个节点的权值之和)

    /**
     * 统计词频
     * @param str string
     * @return hashmap
     */
    public HashMap<String, HFMNode> statisticalWordFrequency(String str){
        int all = str.length();
        HashMap<String, HFMNode> hashMap = new HashMap<>(16);
        for (int i = 0; i < all; i++) {
            String s = str.charAt(i) + "";
            if (!hashMap.containsKey(s)){
                hashMap.put(s, new HFMNode(1, s, null, null));
            }
            else{
                hashMap.put(s, new HFMNode(hashMap.get(s).weight + 1, s, null, null));
            }
        }
        return hashMap;
    }

    /**
     * 使用优先队列: 每次都获得最小的节点
     * @param hashMap hashMap
     * @return priorityQueue
     */
    public PriorityQueue<HFMNode> sortNode(HashMap<String, HFMNode> hashMap){
        PriorityQueue<HFMNode> priorityQueue = new PriorityQueue<>();
        for (String k : hashMap.keySet()){
            priorityQueue.add(hashMap.get(k));
        }
        return priorityQueue;
    }

    /**
     * 创建huffman树
     * @param priorityQueue priorityQueue
     * @return HFMNode
     */
    public HFMNode createHFMNode(PriorityQueue<HFMNode> priorityQueue){

        while (priorityQueue.size() != 1){
            HFMNode left = priorityQueue.poll();
            HFMNode right = priorityQueue.poll();
            HFMNode node = new HFMNode(left.weight + right.weight , left.s + right.s, left, right);
            priorityQueue.add(node);
        }
        return priorityQueue.poll();
    }
}

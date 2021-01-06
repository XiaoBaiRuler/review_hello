package test;

import tree.HFMNode;
import tree.HFMTree;
import tree.LearnBinaryTree;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @Author xiaobai
 * @Date 2021/1/4 11:04
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        HFMTree hfmTree = new HFMTree();
        HashMap<String, HFMNode> hashMap = hfmTree.statisticalWordFrequency("xiaobai");
        PriorityQueue<HFMNode> priorityQueue = hfmTree.sortNode(hashMap);
        HFMNode root = hfmTree.createHFMNode(priorityQueue);
        System.out.println(root);
    }
}

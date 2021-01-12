package test;

import stack.MinStack;
import tree.HFMNode;
import tree.HFMTree;
import tree.LearnBinaryTree;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @Author xiaobai
 * @Date 2021/1/4 11:04
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
//        HFMTree hfmTree = new HFMTree();
//        HashMap<String, HFMNode> hashMap = hfmTree.statisticalWordFrequency("xiaobai");
//        PriorityQueue<HFMNode> priorityQueue = hfmTree.sortNode(hashMap);
//        HFMNode root = hfmTree.createHFMNode(priorityQueue);
//        System.out.println(root);
//        MinStack minStack = new MinStack();
//        minStack.push(-2);
//        minStack.push(0);
//        minStack.push(-3);
//        System.out.println(minStack.getMin());
//        minStack.pop();
//        System.out.println(minStack.top());
//        System.out.println(minStack.getMin());

        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 12482; i++) {
            linkedList.add(i);
        }
        printList(linkedList.iterator());
    }

    /**
     * 12482
     * @param ite ite
     */
    public static void printList(Iterator<Integer> ite){
        if (!ite.hasNext()){
            return;
        }
        System.out.println(ite.next());
        printList(ite);
    }
}

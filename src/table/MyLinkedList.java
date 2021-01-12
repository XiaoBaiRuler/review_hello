package table;

import org.omg.CORBA.Any;

import java.util.Iterator;

/**
 * @Author xiaobai
 * @Date 2021/1/7 10:37
 * @Version 1.0
 */
public class MyLinkedList<AnyType> implements Iterator<AnyType> {

    private int theSize;
    /**
     * 代表自从构造依赖对链表所做改变的次数
     * 为了当一个迭代器被建立时，他将存储集合的modCount;
     * 每次对一个迭代器方法(next或remove)的调用都将用该链表内的当前modCount检测在迭代器内存储的modCount
     * 如果两个modCount不匹配，就抛出ConcurrentModificationException
     */
    private int modCount = 0;
    private Node<AnyType> beginMarker;
    private Node<AnyType> endMarker;

    public MyLinkedList() {
        clear();
    }

    public void clear(){
        beginMarker = new Node<AnyType>(null, null, null);
        endMarker = new Node<AnyType>(null, beginMarker, null);
        beginMarker.next = endMarker;
        theSize = 0;
        modCount ++;
    }

    public int size(){
        return theSize;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public boolean add(AnyType x){
        add(size(), x);
        return true;
    }

    public void add(int index, AnyType x){
        addBefore(getNode(index), x);
    }

    private void addBefore(Node<AnyType> p, AnyType x) {
        Node<AnyType> newNode = new Node<AnyType>(x, p.prev, p);
        newNode.prev.next = newNode;
        p.prev = newNode;
        theSize ++;
        modCount ++;
    }

    public AnyType get(int index){
        return getNode(index).data;
    }

    public Node<AnyType> getNode(int index){
        Node<AnyType> p;
        if (index < 0 || index > size()){
            throw new IndexOutOfBoundsException();
        }
        if (index < size() / 2){
            p = beginMarker.next;
            for (int i = 0; i < index; i++) {
                p = p.next;
            }
        }
        else{
            p = endMarker;
            for (int i = size(); i > index; i--) {
                p = p.prev;
            }
        }
        return p;
    }

    public AnyType set(int index, AnyType newVal){
        Node<AnyType> p = getNode(index);
        AnyType oldVal = p.data;
        p.data = newVal;
        return oldVal;
    }

    public AnyType remove(int index){
        return remove(getNode(index));
    }

    private AnyType remove(Node<AnyType> p){
        p.next.prev = p.prev;
        p.prev.next = p.next;
        theSize --;
        modCount ++;

        return p.data;
    }

    public java.util.Iterator<AnyType> iterator(){
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements java.util.Iterator<AnyType>{

        private Node<AnyType> current = beginMarker.next;
        private int expectedModCount = modCount;
        private boolean okToRemove = false;

        @Override
        public boolean hasNext() {
            return current != endMarker;
        }

        @Override
        public AnyType next() {
            if (modCount != expectedModCount){
                throw new java.util.ConcurrentModificationException();
            }
            if (!hasNext()){
                throw new java.util.NoSuchElementException();
            }
            AnyType nextItem = current.data;
            current = current.next;
            okToRemove = true;
            return nextItem;
        }

        @Override
        public void remove() {
            if (modCount != expectedModCount){
                throw new java.util.ConcurrentModificationException();
            }
            if (!okToRemove){
                throw new IllegalStateException();
            }
            //跳到下一个，才允许之前那个
            MyLinkedList.this.remove(current.prev);
            okToRemove = false;
            expectedModCount ++;
        }
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public AnyType next() {
        return null;
    }


    private static class Node<AnyType>{

        public AnyType data;
        public Node<AnyType> prev;
        public Node<AnyType> next;

        public Node(AnyType d, Node<AnyType> p, Node<AnyType> n){
            data = d;
            prev = p;
            next = n;
        }
    }
}
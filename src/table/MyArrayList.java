package table;

import java.util.NoSuchElementException;

/**
 * @Author xiaobai
 * @Date 2021/1/7 10:03
 * @Version 1.0
 */
public class MyArrayList<AnyType> {
    private static final int DEFAULT_CAPACITY = 10;

    private int theSize;
    private AnyType[] theItems;

    public MyArrayList() {
        clear();
    }

    public void clear(){
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    private void ensureCapacity(int newCapacity) {
        if (newCapacity < theSize){
            return;
        }
        AnyType[] old = theItems;
        theItems = (AnyType[]) new Object[newCapacity];
        for (int i = 0; i < size(); i++) {
            theItems[i] = old[i];
        }
    }

    private int size() {
        return theSize;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public void trimToSize(){
        ensureCapacity(size());
    }
    public AnyType get(int index){
        if (index < 0 || index >= size()){
            throw new ArrayIndexOutOfBoundsException();
        }
        return theItems[index];
    }
    public AnyType set(int index, AnyType newVal){
        if (index < 0 || index >= size()){
            throw new ArrayIndexOutOfBoundsException();
        }
        AnyType old = theItems[index];
        theItems[index] = newVal;
        return old;
    }

    public boolean add(AnyType x){
        add(size(), x);
        return true;
    }
    public void add(int index, AnyType x){
        if (theItems.length == size()){
            ensureCapacity(size() * 2 + 1);
        }
        for (int i = theSize; i > index; i--) {
            theItems[i] = theItems[i - 1];
        }
        theItems[index] = x;
        theSize ++;
    }
    public AnyType remove(int index){
        AnyType removedItem = theItems[index];
        for (int i = index; i < size(); i++) {
            theItems[i] = theItems[i + 1];
        }
        theSize --;
        return removedItem;
    }

    public java.util.Iterator<AnyType> iterator(){
        return new ArrayListIterator();
    }

    /**
     * 每个内部类的对象恰好与外部类的对象的一个实例相关联，就可以使用内部类
     * 内部类对外部类对象的一个隐式调用: Outer.this.xxx;
     * 当不存在同名冲突，Outer.this.theItems可以简写为theItems
     */
    private class ArrayListIterator implements java.util.Iterator<AnyType>{

        private int current = 0;

        @Override
        public boolean hasNext() {
            return current < size();
        }

        @Override
        public AnyType next() {
            if (!hasNext()){
                throw new NoSuchElementException();
            }
            return theItems[current ++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(-- current);
        }
    }
}

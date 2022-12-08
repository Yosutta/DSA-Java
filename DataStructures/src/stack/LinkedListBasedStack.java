package stack;

import java.util.Iterator;
import linkedlist.TinDoublyLinkedList;

public class LinkedListBasedStack<T> implements StackADT<T>{
    private TinDoublyLinkedList<T> list;
    private int index = -1;

    public LinkedListBasedStack(){
        list = new TinDoublyLinkedList<>();
    }

    @Override
    public void push(T element) {
        if(element == null) throw new IllegalArgumentException("Data can not be null");
        list.addLast(element);
        index++;
    }

    @Override
    public T pop() {
        T data = list.removeLast();
        index--;
        return data;
    }

    @Override
    public T top() {
        return list.peekLast();
    }

    @Override
    public int size() {
        return list.size();
    }


    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public String toString() {
        return list.toString();
    }
}

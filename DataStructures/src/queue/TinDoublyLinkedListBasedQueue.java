package queue;

import linkedlist.TinDoublyLinkedList;

import java.util.Iterator;

public class TinDoublyLinkedListBasedQueue<T> implements QueueADT<T>{
    private TinDoublyLinkedList<T> list = new TinDoublyLinkedList<>();
    private int front;
    private int end;

    public TinDoublyLinkedListBasedQueue(){
    }

    public TinDoublyLinkedListBasedQueue(T element){
        if(element == null) throw new IllegalArgumentException("Element can not be null");
        enQueue(element);
    }

    @Override
    public void enQueue(T element) {
        if(element == null) throw new IllegalArgumentException("Element can not be null");
        list.add(element);
    }

    @Override
    public T deQueue() {
        if(isEmpty()) throw new IllegalArgumentException("Queue is Empty");
        T data = list.peekFirst();
        list.removeFirst();
        return data;
    }

    @Override
    public T peek() {
        return list.peekFirst();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.size()==0;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public String toString() {
        return list.toString();
    }
}

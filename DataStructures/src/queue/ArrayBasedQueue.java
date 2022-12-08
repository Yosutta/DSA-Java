package queue;

import java.awt.desktop.AboutEvent;
import java.util.Arrays;
import java.util.Iterator;
import array.DynamicArray;

public class ArrayBasedQueue<T> implements QueueADT<T> {
    private T[] arr;
    private int front;
    private int end;
    private int size;

    private boolean isFull;

    public ArrayBasedQueue(){
        front = end = 0;
        arr = (T[]) new Object[10];
        size = 10;
        isFull = false;
    }

    public ArrayBasedQueue(int capacity){
        front = end = 0;
        arr = (T[]) new Object[capacity];
        size = capacity;
        isFull = false;
    }

    @Override
    public void enQueue(T element) {
        if(element == null) throw new IllegalArgumentException("Element can not be null");
        if(end == front && !isEmpty()) throw new IllegalArgumentException("Queue is full");
        arr[end] = element;
        if(++end == size) {
            end=0;
            isFull = true;
        }
    }

    @Override
    public T deQueue() {
        if(front == end && isEmpty()) throw new IllegalArgumentException("Queue is empty");
        T data = arr[front];
        arr[front] = null;
        if(++front == size) {
            front=0;
            isFull = false;
        }
        return data;
    }

    @Override
    public T peek() {
        if(front == end && isEmpty()) throw new IllegalArgumentException("Queue is empty");
        T data = arr[front];
        return data;
    }

    @Override
    public int size() {
        if(front>end) return size - front +end;
        return end - front;
    }

    @Override
    public boolean isEmpty() {
        return !isFull && front==end;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }
}

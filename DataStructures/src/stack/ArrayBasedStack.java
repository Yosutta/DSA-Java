package stack;
import array.DynamicArray;

import java.util.Iterator;

public class ArrayBasedStack<T> implements StackADT<T> {
    private final DynamicArray<T> stack;
    private int index = -1;
    public ArrayBasedStack(){
        stack = new DynamicArray<>();
    }

    public ArrayBasedStack(int capacity){
        stack = new DynamicArray<>(capacity);
    }

    @Override
    public void push(T element) {
        if(element == null) throw new IllegalArgumentException("Data can not be null");
        stack.add(element);
        index++;
    }

    @Override
    public T pop() {
        T removedElement = stack.removeLast(index);
        index--;
        return removedElement;
    }

    @Override
    public T top() {
        return stack.get(index);
    }

    @Override
    public int size() {
        return stack.size();
    }

    public int capacity() {
        return stack.capacity();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public String toString() {
        return stack.toString();
    }
}

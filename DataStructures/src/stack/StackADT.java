package stack;


import java.util.Iterator;

public interface StackADT<T> extends Iterator<T> {
    void push(T element);
    T pop();
    T top();
    int size();
    boolean isEmpty();

    @Override
    default boolean hasNext() {
        return false;
    }

    @Override
    default T next() {
        return null;
    }
}

package array;

import java.util.Iterator;

public class DynamicArray<T> implements Iterable {

    private T[] arr;
    private int capacity;
    private int size=0;

    public DynamicArray (){
//        this(10);
        capacity = 10;
        arr = (T[]) new Object[capacity];
    }

    public DynamicArray(int capacity){
        if(capacity<0) throw new IllegalArgumentException("Capacity cannot be negative: "+ capacity);
//        Trong java tất cả đều là object cho nên ở đây khai báo là Object, sau thì cast về dạng generic
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
    }

    public int size(){
        return size;
    }

    public int capacity(){
        return capacity;
    }

    public boolean isEmpty(){
        return size()==0;
    }

    public T get(int index){
        return arr[index];
    }

    public void set(int index, T element){
        arr[index] = element;
        size++;
    }

    public void clear(){
        for(int i = 0; i < size; i++){
            arr[i] = null;
        }
        size = 0;
    }

    public void add(T element){
        if(size >= capacity-1){
            if(capacity == 0) capacity = 1;
            else{
                capacity *= 2;
            }
            T[] newArr = (T[]) new Object[capacity];
//          Tại sao ở đây không dùng size mà lại dùng arr.length()
            for (int i=0; i<size; i++){
                newArr[i] = arr[i];
            }
            arr = newArr;
        }
        arr[size++] = element;
    }

    public void removeAt(int removeIndex){
        if (removeIndex > size || removeIndex < 0) throw new IndexOutOfBoundsException("Index out of bound");
        T[] newArr = (T[]) new Object[size-1];

        for(int oldArrIndex = 0, newArrIndex = 0; oldArrIndex<size; oldArrIndex++, newArrIndex++){
            if(oldArrIndex == removeIndex) newArrIndex--;
            else{
                newArr[newArrIndex] = arr[oldArrIndex];
            }
        }
        arr = newArr;
        capacity = --size;
    }

    public T removeLast(int removeIndex){
        T data = arr[removeIndex];
        removeAt(size-1);
        return data;
    }

    public void remove(Object object){
        int removeIndex = indexOf(object);
        removeAt(removeIndex);
    }

    public int indexOf(Object object) {
        for(int i=0;i<size;i++){
            if(object == null){
                if(arr[i] == null) return i;
            }
            else if(object.equals(arr[i])){
                return i;
            }
        }
        return -1;
    }

    public boolean contains(Object object){
        return indexOf(object) != -1;
    }

    public String toString(){
        if(size == 0) return "[]";
        else{
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for(int i =0; i<size-1; i++) {
                sb.append(arr[i] + ",");
            }
            sb.append(arr[size-1] + "]");
            return sb.toString();
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            int index;
            @Override
            public boolean hasNext() {
                return index < size();
            }

            @Override
            public T next() {
                return arr[index++];
            }
        };
    }
}

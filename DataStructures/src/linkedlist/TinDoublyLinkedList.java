package linkedlist;

import java.util.Iterator;

public class TinDoublyLinkedList<T> implements DoublyLinkedList<T>{
    private int size;
    private Node<T> head = null;
    private Node<T> tail = null;

    @Override
    public void clear() {
        Node<T> currentNode = head;
        while(currentNode != null){
            Node<T> nextNode = currentNode.getNext();
            currentNode.setData(null);
            currentNode.setNext(null);
            currentNode.setPrev(null);
            currentNode = nextNode;
        }
        head = tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public void add(T element) {
        addLast(element);
    }

    @Override
    public void addFirst(T element) {
        if(element == null) throw new IllegalArgumentException("Node data can not be null.");
        else{
            Node<T> newNode;
            if(size == 0){
                newNode = new Node<>(element, null, null);
                tail = newNode;
            }
            else{
                newNode = new Node<>(element, null, head);
                head.setPrev(newNode);
            }
            head = newNode;
            size++;
        }
    }

    @Override
    public void addLast(T element) {
        if(element == null) throw new IllegalArgumentException("Node data can not be null.");
        else{
            Node<T> newNode;
            if(size == 0){
                newNode = new Node<>(element, null, null);
                head = newNode;
            }
            else{
                newNode = new Node<>(element, tail, null);
                tail.setNext(newNode);
            }
            tail = newNode;
            size++;
        }
    }

    @Override
    public T peekFirst() {
        if(isEmpty()) throw new RuntimeException("Empty linked list");
        return head.getData();
    }

    @Override
    public T peekLast() {
        if(isEmpty()) throw new RuntimeException("Empty linked list");
        return tail.getData();
    }

    @Override
    public T removeFirst() {
        if(isEmpty()) throw new RuntimeException("Empty linked list");
//        T data = head.getData();
//        head = head.getNext();
//        size--;
        Node<T> removeNode = head;
        head = head.getNext();
        T data = removeNode.getData();
        removeNode.setData(null);
        removeNode.setNext(null);
        size--;
        if(isEmpty()) tail=null;
        else{
            head.setPrev(null);
        }
        return data;
    }

    @Override
    public T removeLast() {
        if(isEmpty()) throw new RuntimeException("Empty linked list");
//        T data = tail.getData();
//        tail = tail.getPrev();
//        size--;
        Node<T> removeNode = tail;
        tail = tail.getPrev();
        T data = removeNode.getData();
        removeNode.setData(null);
        removeNode.setPrev(null);
        size--;
        if(isEmpty()) head=null;
        else{
            tail.setNext(null);
        }
        return data;
    }

    @Override
    public T remove(Node<T> node) {
        if(node.getPrev()==null) removeFirst();
        if(node.getNext()==null) removeLast();

        node.getPrev().setNext(node.getNext());
        node.getNext().setPrev(node.getPrev());

        T data = node.getData();
        size--;

        node.setPrev(null);
        node.setNext(null);
        node.setData(null);
        node = null;

        return data;
    }

    @Override
    public boolean remove(Object object) {
        Node<T> currentNode = head;

        if(object == null){
            while(currentNode!=null){
                if(currentNode.getData()==null){
                    remove(currentNode);
                    return true;
                }
                currentNode = currentNode.getNext();
            }
        }
        else if(object!=null){
            while(currentNode!=null){
                if(currentNode.getData()==object){
                    remove(currentNode);
                    return true;
                }
                currentNode = currentNode.getNext();
            }
        }
        return false;
    }

    @Override
    public T removeAt(int index) {
        return null;
    }

    @Override
    public int indexOf(Object object) {
        return 0;
    }

    @Override
    public boolean contains(Object object) {
        return false;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> currentNode = head;
        while(currentNode!=null){
            if(currentNode.getNext()!=null){
                sb.append(currentNode.getData()).append(", ");
            }
            else{
                sb.append(currentNode.getData());
            }
            currentNode = currentNode.getNext();
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public T next() {
                return null;
            }
        };
    }
}

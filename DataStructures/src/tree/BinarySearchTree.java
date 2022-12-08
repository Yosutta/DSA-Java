package tree;

import queue.QueueADT;
import queue.TinDoublyLinkedListBasedQueue;
import stack.LinkedListBasedStack;
import stack.StackADT;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class BinarySearchTree<T extends Comparable<T>> implements TreeADT<T> {
    private int nodeCount = 0;
    private Node root;

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return nodeCount;
    }

    @Override
    public int height() {
        return height(root);
    }

    @Override
    public boolean contains(T element) {
        return contains(element, root);
    }

    @Override
    public boolean add(T element) {
        if(contains(element)) return false;
        root = add(element, root);
        nodeCount++;
        return true;

    }

    @Override
    public boolean remove(T element) {
        if(!contains(element)) return false;
        root = remove(element, root);
        nodeCount--;
        return true;
    }

    @Override
    public Iterator<T> traverse(TreeTraverseType type) {
        switch (type){
            case PRE_ORDER : return preOrderTraverse();
            case POST_ORDER : return postOrderTraverse();
            case IN_ORDER : return inOrderTraverse();
            case LEVEL_ORDER : return levelOrderTraverse();
            default : return null;
        }
    }

    private Iterator<T> preOrderTraverse(){
        final int currentCount = nodeCount;
        StackADT<Node> stack = new LinkedListBasedStack<>();
        stack.push(root);

        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                if(currentCount != nodeCount) throw new ConcurrentModificationException();
                return root!=null && !stack.isEmpty();
            }

            @Override
            public T next() {
                if(currentCount != nodeCount) throw new ConcurrentModificationException();
                Node node = stack.pop();
                if(node.getRight()!=null) stack.push(node.getRight());
                if(node.getLeft()!=null) stack.push(node.getLeft());
                return (T) node.getData();
            }
        };
    }

    private Iterator<T> postOrderTraverse(){
        final int currentCount = nodeCount;
        StackADT<Node> stack = new LinkedListBasedStack<>();
        stack.push(root);

        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                if(currentCount != nodeCount) throw new ConcurrentModificationException();
                return root!=null && !stack.isEmpty();
            }

            @Override
            public T next() {
                if(currentCount != nodeCount) throw new ConcurrentModificationException();
                Node node = stack.pop();
                if(node.getLeft()!=null) stack.push(node.getLeft());
                if(node.getRight()!=null) stack.push(node.getRight());
                return (T) node.getData();
            }
        };
    }

    private Iterator<T> inOrderTraverse() {
        final int currentCount = nodeCount;
        StackADT<Node> stack = new LinkedListBasedStack<>();
        stack.push(root);

        return new Iterator<T>() {
            Node trav = root;
            @Override
            public boolean hasNext() {
                if(currentCount != nodeCount) throw new ConcurrentModificationException();
                return root!=null && !stack.isEmpty();
            }

            @Override
            public T next() {
                if(currentCount != nodeCount) throw new ConcurrentModificationException();
                while(trav != null && trav.getLeft() != null){
                    stack.push(trav.getLeft());
                    trav = trav.getLeft();
                }
                Node node = stack.pop();

                if(node.getRight()!=null){
                    stack.push(node.getRight());
                    trav = node.getRight();
                }
                return (T) node.getData();
            }
        };
    }

    private Iterator<T> levelOrderTraverse(){
        final int currentCount = nodeCount;
        QueueADT<Node> queue = new TinDoublyLinkedListBasedQueue<>();
        queue.enQueue(root);

        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                if(currentCount != nodeCount) throw new ConcurrentModificationException();
                return root!=null && !queue.isEmpty();
            }

            @Override
            public T next() {
                if(currentCount != nodeCount) throw new ConcurrentModificationException();
                if(!queue.isEmpty()){
                    Node node = queue.deQueue();
                    if(node.getLeft() != null) queue.enQueue(node.getLeft());
                    if(node.getRight() != null) queue.enQueue(node.getRight());
                    return (T) node.getData();
                }
                else return null;
            }
        };
    }


    // PRIVATE
    private int height(Node node){
        if(node == null) return 0;
        else return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    }

    private boolean contains(T element, Node node){
        if(node == null) return false;

        int result = element.compareTo((T) node.getData());

        if(result < 0) return contains(element, node.getLeft());
        else if(result > 0) return contains(element, node.getRight());
        else return true;
    }

    private Node add(T element, Node node){
        if(node == null){
            node = new Node(element, null ,null);
        }
        else{
            if(element.compareTo((T) node.getData()) < 0){
                node.setLeft(add(element, node.getLeft()));
            }
            else {
                node.setRight(add(element, node.getRight()));
            }
        }
        return node;
    }

    private Node remove(T element, Node node){
        int compareResult = element.compareTo((T) node.getData());
        if(compareResult > 0){
            node.setRight(remove(element, node.getRight()));
        }
        else if(compareResult < 0){
            node.setLeft(remove(element, node.getLeft()));
        }
        else{
            if(node.getLeft() == null){
                Node rightNode = node.getRight();

                node.setData(null);
                node = null;

                return rightNode;
            }
            else if(node.getRight() == null){
                Node leftNode = node.getLeft();

                node.setData(null);
                node = null;

                return leftNode;
            }
            else{
                T tmp = maxLeft(node);

                node.setData(tmp);

                node.setLeft(remove(tmp, node.getLeft()));
            }
        }
        return node;
    }

    private T maxLeft(Node node){
        while(node.getRight() != null) node = node.getRight();
        return (T) node.getData();
    }
}

package hashtable;

import linkedlist.DoublyLinkedList;
import linkedlist.TinDoublyLinkedList;

import java.util.Arrays;
import java.util.Iterator;

public class SeperateChainingHashTable<K,V> implements HashTableADT<K,V>{
    private static final int DEFAULT_CAPACITY = 10;
    private static final double DEFAULT_LOAD_FACTOR = 0.5;

    private final double loadFactor;
    private int size=0, capacity, threshold;

    private TinDoublyLinkedList<Node<K, V>>[] table;

    public SeperateChainingHashTable(){
        this(DEFAULT_LOAD_FACTOR, DEFAULT_CAPACITY);
    }

    public SeperateChainingHashTable(int capacity){
        this(DEFAULT_LOAD_FACTOR, capacity);
    }

    public SeperateChainingHashTable(double loadFactor, int capacity){
        super();
        if(capacity<0) throw new IllegalArgumentException("Capacity can not be negative");
        if(loadFactor <= 0 || Double.isNaN(loadFactor) || Double.isFinite(loadFactor))
        throw new IllegalArgumentException("Load factor can not be equal or less than 0.");

        this.capacity = Math.max(DEFAULT_CAPACITY, capacity);
        this.loadFactor = loadFactor;
        this.threshold = (int) (this.capacity * loadFactor);
        table = new TinDoublyLinkedList[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size()==0;
    }

    @Override
    public void clear() {
        Arrays.fill(table, null);
        size=0;
    }

    @Override
    public int hashToIndex(int hashedKey) {
        return (int) (hashedKey & 0xFFFFFFFFFL)/capacity;
    }

    @Override
    public boolean has(K key) {
        int index = hashToIndex(key.hashCode());
        DoublyLinkedList<Node<K,V>> list = table[index];
        if(list==null||list.isEmpty()) return false;
        Iterator<Node<K,V>> iterator = list.iterator();
        while(iterator.hasNext()){
            Node<K,V> node = iterator.next();
            if(node.getKey().equals(key)) return true;
        }
        return false;
    }

    @Override
    public V insert(K key, V value) {
        int index = hashToIndex(key.hashCode());
        DoublyLinkedList<Node<K,V>> list = table[index];
        if(list==null) table[index] = (TinDoublyLinkedList<Node<K, V>>) (list = new TinDoublyLinkedList<>());

        Node<K,V> existedNode = null;
        Iterator<Node<K,V>> iterator = list.iterator();
        while(iterator.hasNext()){
            Node<K,V> node = iterator.next();
            if(node.getKey().equals(key)) existedNode=node;
        }

        if(existedNode==null){
            list.add(new Node<>(key, value));
            if(++size>threshold) resizeTable();
            return null;
        }
        else{
             V oldValue = existedNode.getValue();
             existedNode.setValue(value);
             return oldValue;
        }
    }

    private void resizeTable() {
    }

    @Override
    public V get(K key) {
        int index = hashToIndex(key.hashCode());
        DoublyLinkedList<Node<K,V>> list = table[index];
        if(list==null||list.isEmpty()) return null;
        Iterator<Node<K,V>> iterator = list.iterator();
        while(iterator.hasNext()){
            Node<K,V> node = iterator.next();
            if(node.getKey().equals(key)) return node.getValue();
        }
        return null;
    }

    @Override
    public V remove(K key) {
        int index = hashToIndex(key.hashCode());
        DoublyLinkedList<Node<K,V>> list = table[index];
        if(list==null||list.isEmpty()) return null;
        Iterator<Node<K,V>> iterator = list.iterator();
        while(iterator.hasNext()){
            Node<K,V> node = iterator.next();
            if(node.getKey().equals(key)) {
                list.remove(node);
                --size;
                return node.getValue();
            }
        }
        return null;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public K next() {
                return null;
            }
        };
    }
}

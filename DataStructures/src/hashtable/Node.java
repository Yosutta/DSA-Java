package hashtable;

public class Node<K,V> {
    private int hash;
    private K key;
    private V value;

    public Node(K key,V value){
        this.hash = key.hashCode();
        this.key = key;
        this.value = value;
    }

    public boolean equals(Node<K,V> otherNode){
        if(otherNode.hash != this.hash) return false;
        return this.key.equals(otherNode.key);
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "[Key: " + key + ",Value: " + value + "]";
    }
}

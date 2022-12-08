package hashtable;

public interface HashTableADT<K,V> extends Iterable<K>{
    int size();
    boolean isEmpty();
    void clear();
    int hashToIndex(int hashedKey);
    boolean has(K key);
    V insert(K key, V value);
    V get(K key);
    V remove(K key);
}

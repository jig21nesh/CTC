/**
 * Created by jigneshkakkad on 29/03/2016.
 */
public class HashTableItem <K, V> {
    K key;
    V value;
    HashTableItem<K, V> next;

    public HashTableItem(K key, V value){
        this.key = key;
        this.value = value;
        this.next = null;
    }

    public K getKey(){
        return this.key;
    }
    public V getValue(){
        return this.value;
    }
}

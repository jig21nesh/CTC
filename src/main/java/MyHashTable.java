/**
 * Created by jigneshkakkad on 29/03/2016.
 */
public class MyHashTable<K, V>{

    private HashTableItem<K, V>[] INTERNAL_ARRAY = null;
    private final int TABLE_SIZE = 32;
    private int size;

    private final void doNulls(){
        for(int index = 0; index < TABLE_SIZE; index++){
            INTERNAL_ARRAY[index] = null;
        }
    }

    public MyHashTable(){
        INTERNAL_ARRAY = new HashTableItem[TABLE_SIZE];
        size = 0;
        this.doNulls();
    }

    public int getSize(){
        return size;
    }

    public V get(K key){
        if(key == null){
            return null;
        }else{
            int hash = this.hashMe(key);
            if(INTERNAL_ARRAY[hash] == null){
                return null;
            }else{
                HashTableItem<K, V> hashTableItem = INTERNAL_ARRAY[hash];
                while(hashTableItem.next != null && !hashTableItem.getKey().equals(key)){
                    hashTableItem = hashTableItem.next;
                }
                if(hashTableItem == null){
                    return null;
                }else{
                    return hashTableItem.getValue();
                }
            }
        }
    }

    public void insert(K key, V value){
        int hash = this.hashMe(key);
        if(INTERNAL_ARRAY[hash] == null){
            HashTableItem hashTableItem = new HashTableItem(key, value);
            hashTableItem.next = null;
            INTERNAL_ARRAY[hash] = hashTableItem;
        }else{
            HashTableItem hashTableItem = INTERNAL_ARRAY[hash];
            while(hashTableItem.next != null && !hashTableItem.getKey().equals(key)){
                hashTableItem = hashTableItem.next;
            }
            if(hashTableItem.getKey().equals(key)){
                hashTableItem.value = value;
            }else{
                hashTableItem.next = new HashTableItem(key, value);
            }
        }
        size += 1;
    }

    private int hashMe(K key){
        int hash = key.hashCode() % TABLE_SIZE;
        if(hash < 0){
            hash += TABLE_SIZE;
        }
        return hash;
    }
}

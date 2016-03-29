/**
 * Created by jigneshkakkad on 29/03/2016.
 */
public class Demo {

    public static void main(String[] args) {
        MyHashTable<String, String> table = new MyHashTable<String, String>();
        table.insert("K1", "One");
        table.insert("K2", "Two");
        System.out.println("Size "+table.getSize());
        System.out.println("Value "+table.get("K2")+ " Key K1");
    }
}

import java.util.LinkedList;
import java.util.List;

/**
 * Created by jigneshkakkad on 31/03/2016.
 */
public class KthElementFinder {

    public KthElementFinder(){

    }

    public static void main(String[] args) {
        KthElementFinder kthElementFinder = new KthElementFinder();
        LinkedList<String> t = kthElementFinder.createList();
        kthElementFinder.populateList(t, 10);
        kthElementFinder.printList(t);
    }

    private void printList(LinkedList<String> list){
        for(int index = 0 ; index < list.size(); index++){
            System.out.println(list.get(index));
        }
    }

    private void populateList(LinkedList<String> list, int size){
        for(int index = 0 ; index < size; ++index){
            list.add(String.valueOf(index));
        }
    }

    private LinkedList<String> createList(){
        return new LinkedList<String>();
    }
}

import java.util.Hashtable;

/**
 * Created by jigneshkakkad on 14/04/2016.
 */
public class ListOperations {

    DList list = null;

    ListOperations(){
        list = new DList();
        this.populateTheList();
    }

    public static void main(String[] args) {
        ListOperations deleteDuplicate = new ListOperations();
        deleteDuplicate.doDuplicate();
        System.out.println("List with duplicates");
        deleteDuplicate.print();
        deleteDuplicate.deleteDuplicate();
        System.out.println("List without duplicates");
        deleteDuplicate.print();
        deleteDuplicate.getTheKthElement(5);
        DList d = deleteDuplicate.reverseList();
        System.out.println("Reserved List!!");
        deleteDuplicate.print(d);
    }

    public DList reverseList(){
        DList newList = new DList();
        if(list != null){
            DNode current = list.getFirst();
            do {
                if(newList.isEmpty()){
                    newList.addFirst(new DNode(current.getElement(), null, null));
                }else{
                    newList.addBefore(newList.getFirst(), new DNode(current.getElement(), null, null));
                }
                current = current.getNext();
            }while(current.getNext() != null);
        }
        return newList;
    }

    public void getTheKthElement(int k){
        if(list == null){
            System.out.println("The List is null");
        }else{
            DNode currentHeadVersionOne = list.getFirst();
            DNode currentHeadVersionTwo = list.getFirst();
            int index = 0;
            do{
                if(index < k){
                    currentHeadVersionOne = currentHeadVersionOne.getNext();
                    index += 1;
                }else{
                    break;
                }
            }while(currentHeadVersionOne.getNext() != null);

            do{
                currentHeadVersionOne = currentHeadVersionOne.getNext();
                currentHeadVersionTwo = currentHeadVersionTwo.getNext();
            }while(currentHeadVersionOne.getNext() != null);

            System.out.println("Kth Element >> --- >>> -- >> "+currentHeadVersionTwo.getElement());
        }
    }

    public void deleteDuplicate(){
        Hashtable tracker = new Hashtable();
        DNode current = list.getFirst();
        do{
            if(tracker.contains(current.getElement())) {
                DNode temp = current.getNext();
                list.remove(current);
                current = temp;
            }
            else{
                tracker.put(current.getElement(), current.getElement());
                current = current.getNext();
            }
        }while(current.getNext() != null);
    }
    private void print(DList l){
        if(l.isEmpty()){
            System.out.println("List is empty");
        }else{
            DNode current = l.getFirst();
            do{
                System.out.println(current.getElement());
                current = current.getNext();
            }while(current.getNext() != null);
        }
    }
    private void print(){
        this.print(this.list);
    }

    private void populateTheList(){

        for(int index = 0; index < 10; ++index){
            DNode node = new DNode(String.valueOf(index), null, null);
            if(list.isEmpty()){
                list.addFirst(node);
            }else{
                list.addLast(node);
            }
        }
    }

    private void doDuplicate(){
        this.populateTheList();
    }
}

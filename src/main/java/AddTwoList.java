/**
 * Created by jigneshkakkad on 31/03/2016.
 */
public class AddTwoList {

    public AddTwoList(){

    }

    private void addTwoList(DList firstList, DList secondList){
        String theTotal = String.valueOf(this.getNumber(firstList) + this.getNumber(secondList));
        DList theFinalList = new DList();
        for(int index = theTotal.length()-1 ; index >=0; --index){
            if(theFinalList.size() == 0){
                theFinalList.addFirst(new DNode(String.valueOf(theTotal.charAt(index)), null, null));
            }else{
                theFinalList.addLast(new DNode(String.valueOf(theTotal.charAt(index)), null, null));
            }
        }
        this.printList(theFinalList);
    }

    private int getNumber(DList list){
        int returnInt = 0;
        int multiplier = 1;
        DNode node = list.getFirst();
        do{
            returnInt += Integer.parseInt(node.getElement()) * multiplier;
            node = list.getNext(node);
            multiplier *= 10;
        }while(list.hasNext(node));
        return returnInt;
    }

    public static void main(String[] args) {
        AddTwoList addTwoList = new AddTwoList();
        DList firstList = addTwoList.getList("3", "2", "1");
        DList secondList = addTwoList.getList("3","2", "1");
        addTwoList.addTwoList(firstList, secondList);
    }

    private void printList(DList list){
        DNode node = list.getFirst();
        do{
            System.out.println(node.getElement());
            node = list.getNext(node);
        }while(list.hasNext(node));
    }

    private DList getList(String... digits){
        DList dList = new DList();
        for(String d : digits){
            if(dList.size() == 0)
                dList.addFirst(new DNode(d, null, null));
            else
                dList.addLast(new DNode(d, null, null));
        }
        return dList;
    }
}

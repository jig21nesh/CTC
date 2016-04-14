import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by jigneshkakkad on 14/04/2016.
 */
public class StackOfStacksOperations {

    ArrayList<Stack<Integer>> listOfStack = null;
    private static final int CAPACITY = 2;

    public StackOfStacksOperations(){
        listOfStack = new ArrayList<Stack<Integer>>();
    }

    private Stack<Integer> addNewStack(){
        Stack<Integer> newStack = new Stack<Integer>();
        listOfStack.add(newStack);
        return newStack;
    }

    private Stack<Integer> getLastStack(){
        if(listOfStack.size() == 0){
            this.addNewStack();
        }
        return listOfStack.get(listOfStack.size() - 1);

    }
    public void push(int i){
        Stack<Integer> last = this.getLastStack();
        if(last.size() == CAPACITY){
            this.addNewStack().push(i);
        }else{
            last.push(i);
        }
    }
    public static void main(String[] args) {

    }
}

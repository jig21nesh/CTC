import java.util.Stack;

/**
 * Created by jigneshkakkad on 14/04/2016.
 */
public class StackOperations {
    Stack<Integer> mainStack = null;
    Stack<Integer> trackerStack = null;
    public StackOperations(){
        this.createStack();
    }

    private void createStack(){
        mainStack = new Stack<Integer>();
        trackerStack = new Stack<Integer>();
    }

    private void updateTheTracker(int i){
        if(trackerStack.size() == 0){
            trackerStack.push(i);
        }else{
            if(trackerStack.peek() > i){
                trackerStack.push(i);
            }
        }
    }

    private void push(int i){
        mainStack.push(i);
        this.updateTheTracker(i);
    }

    private void pop(){
        int i = mainStack.pop();
        if(i <= trackerStack.peek()){
            trackerStack.pop();
        }
    }

    public void printMin(){
        this.push(5);
        this.push(6);
        this.push(3);

        System.out.println("Min -- .> "+trackerStack.peek());

        this.push(7);
        this.pop();
        System.out.println("Min -- .> "+trackerStack.peek());
        this.pop();
        System.out.println("Min -- .> "+trackerStack.peek());
    }

    public static void main(String[] args) {
        StackOperations printMin = new StackOperations();
        printMin.printMin();
    }

}

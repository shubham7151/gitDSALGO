package gitDSALGO.Stack.BasicImpl;

public interface Stack {
    
    public void push(int item);

    public int pop() throws Exception;

    public int size();

    public int top();

    public void printStack();
}

package gitDSALGO.Queue.BasicImpl;

public interface Queue {

    public void push(int item);

    public int pop() throws Exception;

    public int size();

    public int top();

    public void printStack();
} 
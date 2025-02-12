package gitDSALGO.Queue.BasicImpl;


public class QueueImpl implements Queue{
    
    private int[] dataStack = new int[16];
    private int start = 0;
    private int end = 0;

    
    @Override
    public void push(int item){
        this.dataStack[end] = item;
        end++;
    }

    @Override
    public int pop() throws Exception{
        if(end-start == 0){
            throw new Exception("No element in arr");
        }
        int popedValue = this.dataStack[start];
        start++;
        return popedValue;
    }

    @Override
    public int size(){
        return end-start;
    }

    @Override
    public int top(){
        return this.dataStack[end];
    }

    @Override
    public void printStack(){
        for(int i = start; i<this.end; i++){
            System.out.println(this.dataStack[i]);
        }
    }
}

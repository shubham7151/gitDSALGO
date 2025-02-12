package gitDSALGO.Stack.BasicImpl;

import gitDSALGO.Stack.BasicImpl.*;

public class StackImpl implements Stack{

    private int[] dataStack = new int[16];
    private int currentSize = 0;
    
    @Override
    public void push(int item){
        this.dataStack[this.currentSize] = item;
        currentSize++;
    }

    @Override
    public int pop() throws Exception{
        if(currentSize==0){
            throw new Exception("No element in arr");
        }
        int popedValue = this.dataStack[currentSize-1];
        this.currentSize--;
        return popedValue;
    }

    @Override
    public int size(){
        return this.currentSize;
    }

    @Override
    public int top(){
        return this.dataStack[currentSize-1];
    }

    @Override
    public void printStack(){
        for(int i = 0; i<this.currentSize; i++){
            System.out.println(this.dataStack[i]);
        }
    }
}

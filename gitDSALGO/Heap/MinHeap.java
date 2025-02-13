package gitDSALGO.Heap;

import java.util.ArrayList;

public class MinHeap {

    /*
     * a min heap is data structure which allow to fetch minimum element
     * it is represented as complete binary tree structure but stored as array
     * it follow Heap property i.e. every element is greater then its all decendents
     * relation between parent childs 
     * Parent location in array = (i+1)/2
     * left child = 2*i +1
     * right child = 2*i + 2
     * Operations :
     *  Heapify :- re arrange element to maintain heap property
     *  add / insert : add element in last and then upHeap : swap with parent till its less then current
     *  remove : remove top most element replace it with last element then heapify it
     */

    private ArrayList<Integer>  arr = null;

    int heapSize = 0;

    public MinHeap(int maxHeapSize){
        this.heapSize = 0;
        arr = new ArrayList<>();
    }

    private int parent(int i){
        return (i-1)/2;
    }
    private int leftChild(int i){
        return 2*i+1;
    }

    private int rightChild(int i){
        return 2*i +2;
    }

    private void swap(int x, int y){
        int temp = arr.get(x);
        arr.set(x, arr.get(y));
        arr.set(y, temp);
    }

    public void heapify(int i){
        if(i > arr.size())return;

        int l = leftChild(i);
        int r = rightChild(i);
        int smallest = i;
        if(l < arr.size() && arr.get(l) < arr.get(i)){
            smallest = l;
        }
        if(r <  arr.size() && arr.get(r) < arr.get(smallest)){
            smallest = r;
        }
        if(smallest!=i){
            swap(i, smallest);
            heapify(smallest);
        }   
    }

    private void heapUp(int i){
        while(i!=0 && arr.get(i) < arr.get(parent(i))){
            swap(i, parent(i));
            System.out.println(arr);
            i = parent(i);
        }
    }
    public void add(int value){
        arr.add(value);
        heapUp(arr.size()-1);
    }

    public void remove(){
        arr.set(0, arr.get(arr.size()-1));
        arr.remove(arr.size()-1);
        heapify(0);
    }

    public void printHeapArr(){
        System.out.println(arr);
    }
    
}

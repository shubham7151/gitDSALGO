package gitDSALGO.Heap;

public class MaxHeap {
    
    /*
     * Heap implementation 
     * given array of complete tree
     * left and right child of ith node = 2*i+1 and 2*i+2
     * set curr as max
     * if left > max set left = max;
     * if right > max set right = max;
     * swap max with curr;
     * 
     */

    private int[] bHeap;
    private int maxSize;
    private int heapSize;

    public MaxHeap(int maxSize){
        this.maxSize = maxSize;
        this.bHeap = new int[maxSize];
        heapSize = 0;
    }

    void heapify(int i){
        int l = lchild(i);
        int r = rchild(i);
        int largest = i;
        if(l < heapSize && bHeap[l] >  bHeap[i]){
            largest = l;
        }
        if(r < heapSize && bHeap[r] > bHeap[largest]){
            largest = r;
        }

        // if largest is new and not equals to i 
        if(largest != i){
            int temp = bHeap[i];
            bHeap[i] = bHeap[largest];
            bHeap[largest] = temp;
            heapify(largest);
        }
    }

    public int lchild(int i){
        return 2*i + 1;
    }

    public int rchild(int i){
        return 2*i + 2;
    }

    public int parent(int i){
        return (i-1)/2;
    }

    public int removeMax(){
        // check if its empty
        // check if it has one element
        // remove first element replace it with last 
        // call heapify
        if(heapSize==0){
            return Integer.MAX_VALUE;
        }
        if(heapSize==1){
            heapSize--;
            return bHeap[0];
        }

        int root = bHeap[0];
        bHeap[0] = bHeap[heapSize-1];
        heapSize--;
        heapify(0);
        return root;

    }

    void deleteMax(int i){
        bHeap[0] = bHeap[bHeap.length-1];
        heapify(0);
    }

    void insertKey(int i){
        if(heapSize == maxSize){
            System.out.println("max reached");
            return;
        }

        heapSize++;
        bHeap[heapSize-1] = i;
        int j = heapSize-1;

        // if the heap property is voklated
        while(j!=0 && bHeap[parent(j)] < bHeap[j]){
            int temp = bHeap[parent(j)];
            bHeap[parent(j)] = bHeap[j];
            bHeap[j] = temp;
            j = parent(j);
        }
    }

    public void printHeapTree() {
        int levels = (int) (Math.log(heapSize) / Math.log(2)) + 1; // Calculate the height of the heap
        int index = 0;
        
        for (int i = 0; i < levels; i++) { // Iterate over levels
            int numElements = (int) Math.pow(2, i); // Elements at current level
            
            // Print leading spaces for tree alignment
            for (int j = 0; j < Math.pow(2, levels - i - 1); j++) {
                System.out.print("  ");
            }
    
            // Print the elements of the current level
            for (int j = 0; j < numElements && index < heapSize; j++) {
                System.out.print(bHeap[index++] + "   ");
            }
    
            System.out.println(); // New line for the next level
        }
    }
    


    public static void main(String[] args) {
        MaxHeap h = new MaxHeap(10);
        h.insertKey(1);
        h.insertKey(4);
        h.insertKey(6);
        h.insertKey(10);
        h.insertKey(9);

        h.removeMax();

        h.insertKey(0);

        h.printHeapTree();
    }
}

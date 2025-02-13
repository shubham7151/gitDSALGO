package gitDSALGO.Heap;

public class HeapTest {
    
    public static void main(String[] args) {
        MinHeap hm = new MinHeap(10);

        hm.add(4);
        hm.add(10);
        hm.add(3);
        hm.add(5);
        hm.add(1);
        hm.remove();

        hm.printHeapArr();
    }
}

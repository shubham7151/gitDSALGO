package gitDSALGO.linkedList.DoublyLinkedList;

public interface DoublyLinkedList<T> {
    
    public Node<T> addNode(Node<T> item);

    public void printLinkedList();

    public void deleteNode(T val);

    public Node<T> updateNode(int pos,T item);

    public Node<T> reverseLinkedList();
}

package gitDSALGO.linkedList.SinglyLinkedList;

public interface LinkedList<T> {
    
    public Node<T> addNode(Node<T> item);

    public void printLinkedList();

    public Node<T> deleteNode(T val);

    public Node<T> updateNode(int pos,T item);

    public Node<T> reverseLinkedList();
}

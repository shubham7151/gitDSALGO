package gitDSALGO.linkedList.SinglyLinkedList;

import gitDSALGO.linkedList.SinglyLinkedList.Node;


public class LinkedListImpl<T> implements LinkedList<T> {

    Node<T> head = null;

    @Override
    public Node<T> addNode(Node<T> item) {
        if(head == null){
            head = item;
        }else {
            Node<T> curr = head;
            while(curr.next != null){
                curr= curr.next;
            }
            curr.next = item;
        }
        return head;
    }
    

    @Override
    public void printLinkedList() {
        Node<T> curr = head;
        while(curr != null){
            System.out.println(curr.data + "--->");
            curr = curr.next;
        }
    }


    @Override
    public Node<T> deleteNode(T val) {
        if(head == null){
            return head;
        }
        if(head.data.equals(val)){
            head = head.next;
            return head;
        }
        Node<T> curr = head;
        Node<T> prev = null;

        while(curr!=null){
            if(curr.data.equals(val)){
                prev.next = curr.next;
            }else {
                prev = curr;
            }
            curr = curr.next;
        }
        return head;
    }


    @Override
    public Node<T> updateNode(int pos, T item) {
        int iterator = 0;
        Node<T> curr = head;
        
        while(curr!=null){
            if(iterator == pos){
                curr.data = item;
                return head;
            }
            curr = curr.next;
            iterator++;
        }

        return head;
    }


    @Override
    public Node<T> reverseLinkedList() {
        if (head == null || head.next == null) {
            return head; 
        }
        Node<T> prev = null;
        Node<T> ahead = head.next;
        Node<T> curr = head;

        while(curr!=null){
            ahead = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ahead;
        }

        head = prev;
        return head;

    }
    

    
    
}

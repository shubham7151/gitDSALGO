package gitDSALGO.linkedList.DoublyLinkedList;

public class DoublyLinkedListImpl<T> implements DoublyLinkedList<T>{

    Node<T> head;

    @Override
    public Node<T> addNode(Node<T> item) {
        if(head == null){
            this.head = item;
        }else{
            Node<T> curr = head;
            while(curr.next!=null){
                curr = curr.next;
            }
            curr.next = item;
            item.prev = curr;
        }

        return head;
    }

    @Override
    public void printLinkedList() {
        if(this.head == null){
            System.out.println("No element in list : please insert one element");
        }else{
            Node<T> curr = head;
            while(curr.next != null){
                System.out.println(curr.data + "----->");
            }
        }
    }

    @Override
    public void deleteNode(Object val) {
        if(head==null){
            System.out.println("No element in list : please insert one element");
        }else{
            Node<T> curr = head;
            while(curr.next != null){
                if(curr.data.equals(val)){
                    curr.prev.next = curr.next;
                    curr.next.prev = curr.prev;
                    break;
                }
                curr = curr.next;
            }
            
        }
    }

    @Override
    public Node updateNode(int pos, Object item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateNode'");
    }

    @Override
    public Node<T> reverseLinkedList() {
        if(head == null){
            return head;
        }else{
            Node<T> curr = head;
            Node<T> previ  = null;

            while(curr!= null){
                previ = curr.prev;
                curr.prev  = curr.next;
                curr.next = previ;
                curr = curr.prev;
            }

            head = previ.prev;

        }

        return head;
    }
    
}

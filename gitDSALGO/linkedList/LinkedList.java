package gitDSALGO.linkedList;


public class LinkedList {

    Node head;
    public class Node{
        int data;
        Node next;
        Node(int d){
            this.data = d;
            next=null;
        }
    }

    // public boolean push(int data){
    //     Node newNode = new Node(data);
    //     if(head==null){

    //     }
    // }


    public static void main(String[] args) {
        System.out.println(new LinkedList());
    }
}

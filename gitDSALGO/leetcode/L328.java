package gitDSALGO.leetcode;

import gitDSALGO.leetcode.L876.ListNode;

public class L328 {
    /*
     * Odd Even Linked List
     */


    public ListNode oddEvenList(ListNode head) {
       // loop through and swap if even
       if(head == null){
        return null;
       }
       
       ListNode odd = head;
       ListNode even = head.next;
       ListNode evenHead = head.next;

       while(even!=null && even.next!=null){
        odd.next = odd.next.next;
        even.next = even.next.next;
        odd=odd.next;
        even=even.next;
       }
       odd.next = evenHead;
       return head;
    }
    public static void main(String[] args) {
        
    }
}

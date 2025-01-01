package gitDSALGO.leetcode;

import gitDSALGO.leetcode.L876.ListNode;

public class L19 {
    
    /*
     * Remove Nth Node From End of List
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode curr = head;
        while(curr!=null){
            length++;
            curr= curr.next;
        }
         
        int indexToDelete = length-n;
        if (indexToDelete == 0) {
        return head.next; // Remove the head by returning the next node
    }
        int i =0;
        curr = head;
        ListNode prev = curr;
        while(curr!=null){
            if(i == indexToDelete){
                prev.next = curr.next;
            }
            i++;
            prev = curr;
            curr= curr.next;
        }

        return head;
    }

    public static void main(String[] args) {
        
    }
}

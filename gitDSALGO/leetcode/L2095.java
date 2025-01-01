package gitDSALGO.leetcode;

import gitDSALGO.leetcode.L876.ListNode;

public class L2095 {
 
    /*
     * Delete the Middle Node of a Linked List
     */
    public ListNode deleteMiddle(ListNode head) {
        if(head.next == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode curr = head;
        while(fast!=null && fast.next != null){
            curr = slow;
            slow=slow.next;
            fast = fast.next.next;
        }
        if(curr.next!=null)
        curr.next = slow.next;

        return head;
    }

    public static void main(String[] args) {
        
    }
}

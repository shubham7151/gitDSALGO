package gitDSALGO.leetcode;

import gitDSALGO.leetcode.L876.ListNode;

public class L141 {
    
    /*
     * Linked List Cycle
     */

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        if(head==null || head.next == null ){
            return false;
        }

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
             if(slow == fast){
                return true;
            }
        }
        return false;   
    }
    public static void main(String[] args) {
        
    }
}

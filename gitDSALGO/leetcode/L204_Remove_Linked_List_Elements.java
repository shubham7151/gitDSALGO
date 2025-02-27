package gitDSALGO.leetcode;

import gitDSALGO.leetcode.L876.ListNode;

public class L204_Remove_Linked_List_Elements {
    
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
       
        ListNode prev = head;
        ListNode curr = head;
        
        while(curr!=null){
            
            if(curr.val==val){
               prev.next = curr.next;
               curr = curr.next;
            }else{
                prev = curr;
                curr = curr.next;
            }
            
        }
         if(head.val == val){
            head = head.next;
        }

        return head;
    }
}

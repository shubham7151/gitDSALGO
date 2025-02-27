package gitDSALGO.leetcode;

import gitDSALGO.leetcode.L876.ListNode;

public class L237_Delete_Node_in_a_Linked_List {
    public void deleteNode(ListNode node) {
        if(node==null || node.next==null){
            return;
        }
        node.val = node.next.val;
        node.next = node.next.next;
        
    }
}

package gitDSALGO.leetcode;

import java.util.HashMap;

import gitDSALGO.leetcode.L876.ListNode;

public class L142 {
    
    /*
     * Linked List Cycle II
     */

    public ListNode detectCycle(ListNode head) {
        ListNode curr = head;
        HashMap<ListNode, Integer> visitedNode = new HashMap<>();
        while(curr!=null){
            if(visitedNode.containsKey(curr)){
                return curr;
            }
            visitedNode.put(curr,1);

            curr = curr.next;
        }

        return null;
    }

    public static void main(String[] args) {
        
    }
}

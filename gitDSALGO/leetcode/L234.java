package gitDSALGO.leetcode;

import gitDSALGO.leetcode.L876.ListNode;

public class L234 {
    
    /*
     * Palindrome Linked List
     */

     public boolean isPalindrome(ListNode head) {
        Stack<Integer> st = new Stack<>();

        ListNode curr = head;
        while(curr!=null){
            st.push(curr.val);
            curr=curr.next;
        }

        curr = head;

        while(curr!=null && !st.isEmpty()){
            if(curr.val != st.pop()){
                return false;
            }
            curr = curr.next;
        }
        return true;
    }
    public static void main(String[] args) {
        
    }
}

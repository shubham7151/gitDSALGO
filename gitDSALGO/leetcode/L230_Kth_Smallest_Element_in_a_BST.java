package gitDSALGO.leetcode;

import javax.swing.tree.TreeNode;

import gitDSALGO.tree.Node;
import java.util.*;

public class L230_Kth_Smallest_Element_in_a_BST {
    
    public int kthSmallest(Node root, int k) {
        // inorder traversal and return kth element
        // ArrayList<TreeNode> arr = new ArrayList<>();
        int count = 0;
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        while(curr!=null || !stack.isEmpty()){
            while(curr!=null){
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            // arr.add(curr);
           
            if(count == k-1){
                return curr.data;
            }
             count++;
            // if(arr.size() == k){
            //     return arr.get(k-1).val;
            // }
            curr = curr.right;
        }

        return -1;
    }
}

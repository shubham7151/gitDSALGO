package gitDSALGO.leetcode;

import gitDSALGO.tree.Node;
import java.util.*;

public class L94_Binary_Tree_Inorder_Traversal {
    
    /*
     * Binary Tree Inorder Traversal
     */

    public static List<Integer> inOrderTraversal(Node root){
        if(root==null) return new ArrayList<>();
        List<Integer> inorder = new ArrayList<>();
        Stack<Node> stack = new Stack<>();

        Node curr = root;
        while(curr!=null || !stack.isEmpty()){
            while(curr!=null){
                stack.push(curr);
                curr= curr.left;
            }

            curr = stack.pop();
            inorder.add(curr.data);
            curr= curr.right;
        }

        return inorder;
    }
}

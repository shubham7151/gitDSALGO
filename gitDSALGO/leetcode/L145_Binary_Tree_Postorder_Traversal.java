package gitDSALGO.leetcode;

import java.util.*;

import gitDSALGO.tree.Node;

public class L145_Binary_Tree_Postorder_Traversal {
    
    /*
     * Binary Tree Postorder Traversal
     */

    public static List<Integer> postOrderTraversal(Node root){
        if(root==null) return new ArrayList<>();

        List<Integer> postorder = new ArrayList<>();
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(root);
        while(!stack1.isEmpty()){
            Node curr = stack1.pop();
            stack2.push(curr);
            if(curr.left!=null){
                stack1.push(curr.left);
            }
            if(curr.right!=null){
                stack1.push(curr.right);
            }
        }

        while(!stack2.isEmpty()){
            postorder.add(stack2.pop().data);
        }

        return postorder;
    }
}

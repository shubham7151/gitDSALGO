package gitDSALGO.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import gitDSALGO.tree.Node;

public class L144_Binary_Tree_Preorder_Traversal {
    /*
     * Binary Tree Preorder Traversal
     */

    public static List<Integer> preorderTraversal(Node root){
        if(root==null){
            return new ArrayList<>();
        }
        List<Integer> preOrder = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node curr = stack.pop();
            preOrder.add(curr.data);
            if(curr.right!=null){
                stack.push(curr.right);
            }
            if(curr.left!=null){
                stack.push(curr.left);
            }
        }

        return preOrder;
    }
}

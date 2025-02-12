package gitDSALGO.leetcode;

import javax.swing.tree.TreeNode;

import gitDSALGO.tree.Node;

public class L450_Delete_Node_in_a_BST {
    
    /*
     * Delete Node in a BST
     */

     public Node deleteNode(Node root, int key) {
        // search the node
        Node curr = root;
        Node currPar = null;
        while( curr!=null && curr.data!=key){
            currPar = curr;
            if(curr.data>key){
                curr = curr.left;
            }else{
                curr = curr.right;
            }
        }

        // check if key exist
        if(curr==null){
            return root;
        }

        // if only no chile
        if(curr.left==null && curr.right==null){
            //check for root
            if(currPar ==  null){
                return null;
            }
            if(currPar.left == curr){
                currPar.left = null;
            }else{
                currPar.right = null;
            }
        }

        // if only one child
        else if( curr.left == null || curr.right == null){
            Node child = curr.left !=null ? curr.left : curr.right;

            if(currPar == null){
                return child;
            }

            // two chile check
            if(currPar.left == curr){
                currPar.left = child;
            }else{
                currPar.right = child;
            }
        }

        // if two child
        // get in order successor replace it with the curr and delete in order successor

        if(curr.left!=null && curr.right!=null){
            Node successor = curr.right;
            Node successorpar = curr;
            // go to left more node
            while(successor.left!=null){
                successorpar = successor;
                successor = successor.left;
            }

            curr.data = successor.data;

            if(successorpar.left == successor) successorpar.left = successor.right;
            else successorpar.right = successor.right;
        }

        return root;
    }
}

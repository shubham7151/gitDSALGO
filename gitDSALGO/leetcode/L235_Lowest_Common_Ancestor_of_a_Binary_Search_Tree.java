package gitDSALGO.leetcode;

import javax.swing.tree.TreeNode;

import gitDSALGO.tree.Node;

public class L235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree {
    
    /*
     * Lowest Common Ancestor of a Binary Search Tree
     */

    public Node lowestCommonAncestor(Node root, Node p, Node q) {
        Node curr = root;
        Node currPar = null;

       while(curr!=null){
        currPar = curr;
        if((curr.data > p.data && curr.data < q.data) || (curr.data < p.data && curr.data > q.data)){
            return currPar;
        }else if(curr == p || curr == q) {
            if(curr== p) return p;
            else return q;
            // if(curr == p ) {
            //     TreeNode temp = curr;
            //     if(q.val > temp.val){
            //         temp = temp.right;
            //     }else if(q.val < temp.val){
            //         temp = temp.left;
            //     }else{
            //         return p;
            //     }
            // }

            // if(curr == q ) {
            //     TreeNode temp = curr;
            //     if(temp.val > p.val){
            //         temp = temp.left;
            //     }else if(temp.val < p.val){
            //         temp = temp.right;
            //     }else{
            //         return q;
            //     }
            // }


        }else if(curr.data > p.data && curr.data > q.data){
            curr = curr.left;
        }else{
            curr = curr.right;
        }
       }
       return currPar;
    }
}

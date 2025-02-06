package gitDSALGO.leetcode;

import gitDSALGO.tree.*;
public class L700_Search_in_a_Binary_Search_Tree {
    
    public Node searchBST(Node root, int val){
        if(root==null) return null;
        if(root.data == val) return root;
        if(root.data < val) return searchBST(root.right, val);
        else return searchBST(root.left, val);
    }
}

package gitDSALGO.leetcode;

import gitDSALGO.tree.Node;

public class L701_Insert_into_a_Binary_Search_Tree {
    
    public Node insertIntoBST(Node root, int val){
        if(root == null) return new Node(val);
        if(root.data > val){
            root.left = insertIntoBST(root.left, val);
        }else{
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}

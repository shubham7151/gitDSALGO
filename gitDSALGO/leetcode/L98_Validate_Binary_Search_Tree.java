package gitDSALGO.leetcode;

import javax.swing.tree.TreeNode;

import gitDSALGO.tree.Node;

public class L98_Validate_Binary_Search_Tree {
 
    /*
     * Validate Binary Search Tree
     */

        public boolean isValidBST(Node root) {
            return isValid(root, Long.MIN_VALUE ,Long.MAX_VALUE);

        }

        public boolean isValid(Node root, Long a, Long b){
            if(root==null) return true;
            if(root.data>b || root.data < a) return false;
            return isValid(root.left, a , (long) root.data-1) && isValid(root.right, (long) root.data+1, b);
        }
}

package gitDSALGO.leetcode;

import gitDSALGO.tree.Node;

public class L110_Balanced_Binary_Tree {
    /*
     * Balanced Binary Tree
     */

    public static boolean isBalanced(Node root){
        if( root == null) return false;
        if(dfs(root) == -1){
            return false;
        } 
        return true;
    }
    public static int dfs(Node root){
        if(root == null){
            return -1;
        }
        int leftHeight = dfs(root.left);
        int rightHeight = dfs(root.right);

        // the reason for this in to propogate the unbalanced tree
        // if not there it unbalanced tree will be over written but the later balanced tree
        /*
         *          a
         *      b       e
         *     c         f
         *    d           g
         * here the unbalanced b subtree will be over written by a balanced tree;
         */
        if(leftHeight == -1 || rightHeight ==-1){
            return -1;
        }
        // place to check unbalanced
        if(Math.abs(leftHeight - rightHeight) >1){
            return -1;
        }
        return 1+Math.max(leftHeight,rightHeight);
    }
}

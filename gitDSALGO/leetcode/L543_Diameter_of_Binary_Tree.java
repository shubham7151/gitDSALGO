package gitDSALGO.leetcode;

import javax.swing.tree.TreeNode;

import gitDSALGO.tree.Node;

public class L543_Diameter_of_Binary_Tree {
    
    /*
     * Diameter of Binary Tree
     */

    static int  max = 0;
    public static int diameterOfBinaryTree(Node root) {
        if(root==null){
            return 0;
        }
        dfs(root);
        return max;
    }

    public static int dfs(Node root){
        if(root==null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        max = Math.max(left+right, max);
        return 1+ Math.max(left, right);
    }
}

package gitDSALGO.leetcode;

import java.util.HashSet;

import javax.swing.tree.TreeNode;

import gitDSALGO.tree.Node;

public class L653_Two_Sum_IV_Input_is_a_BST {
    /*
     * Two Sum IV - Input is a BST
     */

    HashSet<Integer> hs = new HashSet<>();
    public boolean findTarget(Node root, int k) {
        if(root==null) return false;
        if(hs.contains(k-root.data)) return true;
        hs.add(root.data);
        return findTarget(root.left,k) || findTarget(root.right,k);
    }
}

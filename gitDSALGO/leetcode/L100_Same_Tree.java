package gitDSALGO.leetcode;

import gitDSALGO.tree.Node;

public class L100_Same_Tree {
    
    /*
     * Same Tree
     */

    
    public static Boolean isSameTree(Node p, Node q){
        if(p==null | q== null) return true;
        if((p==null && q!=null) || (q==null & p!=null)) return false;

        return isSameTree(q.left,p.left) && isSameTree(p.right, q.right) && q.data==p.data;
    }
}

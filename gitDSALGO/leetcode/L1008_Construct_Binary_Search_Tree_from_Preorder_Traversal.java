package gitDSALGO.leetcode;

import gitDSALGO.tree.Node;

public class L1008_Construct_Binary_Search_Tree_from_Preorder_Traversal {
    
    /*
     * Construct Binary Search Tree from Preorder Traversal
     */

    /*
     * intution behind this is as its preorder first element is root of the tree all following vlaue which is less then root value is on left side while 
     * other in right right
     */

    public Node bstFromPreorder(int[] preorder){
        return helper()
    }

    public Node helper(int[] preorder, int start, int end){
        if(start > end ) return null;

        Node root = new Node(preorder[start]);
        int i;
        for( i = start; i<=end;i++){
            if(preorder[i] > root.data){
                break;
            }
        }

        root.left = helper(preorder, start=1, i-1);
        root.right = helper(preorder, i, end);

        return root;
    }
}

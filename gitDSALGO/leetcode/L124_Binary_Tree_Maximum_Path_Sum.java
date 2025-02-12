package gitDSALGO.leetcode;



import gitDSALGO.tree.Node;

public class L124_Binary_Tree_Maximum_Path_Sum {
    /*
     * Binary Tree Maximum Path Sum
     */

    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(Node root){
        calculateMaxSum(root);
        return maxSum;
    }

    public int calculateMaxSum(Node root){
        if(root==null){
            return 0;
        }

        /*
         * We want maximum substree for if anysubtree result in negaive value which reduce the overall sum we can
         * ignore the substee 
         */
        int leftMax = Math.max(calculateMaxSum(root.left),0);
        int rightMax = Math.max(calculateMaxSum(root.right),0);

        int total = leftMax+rightMax+root.data;
        maxSum = Math.max(maxSum,total);

        /*
        we return max of left and right beacause we need subtree which contribute max to out total.
        */
        return root.data + Math.max(rightMax,leftMax);

    }
}

package gitDSALGO.leetcode;

import java.util.*;

import gitDSALGO.tree.Node;

// import javax.swing.tree.TreeNode

public class L102_Binary_Tree_Level_Order_Traversal {
    
    /*
     * Binary Tree Level Order Traversal
     * intition is for ever level we add null to queue;
     */

    public static List<List<Integer>> levelOrder(Node root){
        Queue<Node> q = new LinkedList<>();
        List<List<Integer>> levelorder = new ArrayList<>();
        List<Integer> levels = new ArrayList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node curr = q.poll();
            if(curr==null){
                // means we reached end of level
                levelorder.add(levels);
                levels = new ArrayList<>();
                if(q.isEmpty()) break;
                q.add(null);
            }else{
                levels.add(curr.data);
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
        }

        return levelorder;
    }

    /*
     * intution : before processing queue we get size of queue which represent the number of nodes at that level and we process them 
     * and at end we add that to result list
     */

    public static List<List<Integer>> levelOrderOptimize(Node root){
        List<List<Integer>> levelOrder = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int levelSize = q.size();
            List<Integer> level = new ArrayList<>();
            for( int i =0; i<levelSize;i++){
                Node curr = q.poll();
                level.add(curr.data);
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            levelOrder.add(level);
        }
        return levelOrder;
    }
}

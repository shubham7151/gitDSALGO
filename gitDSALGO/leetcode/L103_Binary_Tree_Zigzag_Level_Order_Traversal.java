package gitDSALGO.leetcode;

import gitDSALGO.tree.Node;
import java.util.*;
public class L103_Binary_Tree_Zigzag_Level_Order_Traversal {
    
    /*
     * Binary Tree Zigzag Level Order Traversal
     */

    public static List<List<Integer>> zigzagLevelOrder(Node root){

        Queue<Node> q = new LinkedList<>();
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        int height = 0;
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node curr = q.poll();
            if(curr== null){
                if(height%2!=0){
                    Collections.reverse(level);
                }
                output.add(level);
                if(q.isEmpty()) break;
                q.add(null);
                level= new ArrayList<>();
                height++;
            }else{
                level.add(curr.data);
                if(curr.left!=null){
                    q.add(curr.left);
                }if(curr.right!=null){
                    q.add(curr.right);
                }
            }
        }

        return output;
    }
}

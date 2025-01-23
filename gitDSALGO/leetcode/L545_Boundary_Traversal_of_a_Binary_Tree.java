package gitDSALGO.leetcode;

import gitDSALGO.tree.Node;
import java.util.*;
public class L545_Boundary_Traversal_of_a_Binary_Tree {
    
    /*
     * Boundary Traversal of a Binary Tree
     * intution : 
     *  divide tree in three part 1 -> left bounday : left subtree without leaf node;
     *                            2 -> Bottom Bounday : leaves nodes of left and right subtree;
     *                            3 -> right bounday : right subtree without leaf node;
     * 
     * create helper to check leave node check nodes right and left as null;
     * create addLeftBounday check if not leaf add then add left else right;
     * create addRightBounday check if not leaf add add right if not left rever the array add to result;
     * create bottonBounday check if leaf add else move left if ezist else move right;
     *
     */

    public static List<Integer> boundayTraversal(Node root){
        if(root==null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        leftBounday(root, res);
        bottomBoundary(root, res);
        rightBounday(root, res);

        return res;
    }
    public static boolean isLeaf(Node root){
        return root.left==null && root.right==null;
    }
    public static void leftBounday(Node root, List<Integer> res){
        if(root==null){
            return;
        }
        Node curr = root.left;
        while(curr!=null){
            if(!isLeaf(root)){
                res.add(root.data);
            }

            if(curr.left!=null){
                curr = curr.left;
            }else if(curr.right!=null){
                curr = curr.right;
            }
        }
    }
    public static void rightBounday(Node root, List<Integer> res){
        List<Integer> temp = new ArrayList<>();
        if(root==null){
            return;
        }
        Node curr = root.right;
        while(curr!=null){
            if(!isLeaf(root)){
                temp.add(root.data);
            }

            if(curr.right!=null){
                curr = curr.right;
            }else if(curr.left!=null){
                curr = curr.left;
            }
        }
        Collections.reverse(temp);
        res.addAll(temp);
    }

    public static void bottomBoundary(Node root, List<Integer> res){
        if(root==null) return;
        Node curr = root;
        while(curr!=null){
            if(isLeaf(curr)){
                res.add(curr.data);
            }

            if(curr.left!=null){
                bottomBoundary(root.left, res);
            }else{
                bottomBoundary(root.right, res);
            }
        }
    }
}

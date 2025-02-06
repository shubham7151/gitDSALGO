package gitDSALGO.tree;

import gitDSALGO.tree.Node;
import java.util.*;
public class Binary_Search_Tree {
    
    Node root = null;

    public Binary_Search_Tree(Node root){
        this.root = root;
    }

    public void insertRecur(Node n , int val){
        if(this.root== null){
            this.root = new Node(val);
            return;
        }
        if(this.root.data == val){
            return;
        }
        if(this.root.data > val){
            insertRecur(this.root.left, val);
        }else{
            insertRecur(this.root.right, val);
        }
    }

    public void insert(int val){
        if(this.root==null){
            return;

        }

        Node parent = null;
        Node curr = this.root;

        while(curr!=null){
            parent = curr;
            if(curr.data < val){
                curr = curr.right;
            }else if(curr.data > val){
                curr = curr.left;
            }else{
                return;
            }
        }

        if(parent.data> val){
            parent.left = new Node(val);
        }else{
            parent.right = new Node(val);
        }


    }

    public boolean search(int val){
        if(this.root == null){
            return false;
        }

        Node curr = this.root;
        while(curr!=null){
            if(curr.data == val){
                return true;
            }
            if(curr.data < val){
                curr = curr.right;
            }else{
                curr = curr.left;
            }
        }

        return false;
    }

    public boolean search(Node n , int val){
        if(n == null){
            return false;
        }
        if(n.data == val){
            return true;
        }
        if(n.data > val){
            return search(n.left, val);
        }
        return search(n.right, val);
    }
   // better case bt case approah
    // public Node delete(int val){
    //     // if(this.root == null) return null;
    //     Node prev = null;
    //     Node curr = this.root;
    //     while(curr.data!=val && curr!=null){
    //         prev = curr;
    //         if(curr.data > val){
    //             curr = curr.left;
    //         }else{
    //             curr = curr.right;
    //         }
    //     }

    //     if(curr==null){
    //         return this.root;
    //     }
    //     // case 1
    //     if(curr.left==null || curr.right==null){
    //         Node newCurr;
    //         if(curr.left==null){
    //             newCurr = curr.right;
    //         }else{
    //             newCurr = curr.left;
    //         }

    //         // check if node is root or not;
    //         if(prev==null){
    //             return newCurr;
    //         }

    //         if(curr==prev.left){
    //             prev.left = newCurr;
    //         }else{
    //             prev.right = newCurr;
    //         }
    //     }else{
    //         // node has two chile get in order successor meaning left most element in right subtree

    //         Node temp = curr.right;
    //         Node ref = null;
    //         while(temp.left!=null){
    //             ref = temp;
    //             temp = temp.left;
    //         }

    //         if(ref!=null){
    //             ref.left = temp.right;
    //         }else{
    //             curr.right = temp.right;
    //         }

    //         curr.data = temp.data;
    //     }

    //     return root;

    // }

    public Node delete(int val){
        // checkl of tree exist 
        if(this.root==null) return null;
        // search the val in tree
        Node curr = this.root;
        Node parent = null;
        while(curr.data!=val && curr!=null){
            parent = curr;
            if(curr.data > val){
                curr = curr.left;
            }else{
                curr = curr.right;
            }
        }

        // check if value exist by null check
        if(curr==null){
            return this.root;
        }

        // Case 1: vale is leaf node
        if(curr.left==null && curr.right==null){
            // check if its not root
            if(parent==null){
                return null;
            }

            // one with curr is remove by
            if(parent.left==curr){
                parent.left = null;
            }else{
                parent.right = null;
            }

        }else if(curr.left==null || curr.right==null){
            // Case 2 : contains one child
            Node child = curr.left!=null ? curr.left : curr.right;

            // check if not root
            if(parent == null){
                return child;
            }

            if(parent.left==curr){
                parent.left = child;
            }else{
                parent.right = child;
            }
        }else{
            // case 3 : contain two child

            Node successor = curr.right;
            Node successorPar = curr;
            
            // left most element in right sub tree meaning its inorder successor
            while(successor.left!=null){
                successorPar = successor;
                successor = successor.left;
            }
            // replace value with in order successor
            curr.data = successor.data;

            if(successorPar.left == successor){
                successorPar.left = successor.right;
            }else{
                successorPar.right = successor.right;
            }
        }

        return root;
    }

    /*
     * given tree balance it
     */
    public Node balanceBST(){

        if(this.root==null){
            return null;
        }
        List<Integer> sortedArr = new ArrayList<>();
        Stack<Node> stack = new Stack<>();

        // stack.add(root);
        Node curr = root;
        while(curr!=null || !stack.isEmpty()){

            while(curr!=null){
                stack.push(curr);
                curr= curr.left;
            }
            curr = stack.pop();
            sortedArr.add(curr.data);
            curr = curr.right;
        }
        // inorder traversal in sortedArr
        return constructBST(sortedArr,0,sortedArr.size()-1);
    }

    public Node constructBST(List<Integer> arr, int start, int end){
        if(start>end){
            return null;
        }
        int mid = (start+end)/2;
        Node root = new Node(arr.get(mid));
        // construct left
        root.left = constructBST(arr, start, mid-1);
        root.right = constructBST(arr, mid+1, end);
        return root;
    }

    /*
     * is BST
     * intution is a BSt left sub stree vales are 1 less then root and right are one greater then root
     */

    public boolean isBST(Node root){
        return helperUtil(root,Integer.MIN_VALUE, Integer.MAX_VALUE);
    } 
    public boolean helperUtil(Node root, int min, int max){
        if(root==null) return true;
        if(root.data > max || root.data<min) return false;
        return helperUtil(root.left, min, root.data+1) && helperUtil(root.right, root.data-1, max);
    }
}

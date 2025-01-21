package gitDSALGO.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;

import gitDSALGO.tree.Node;

public class Binary_Tree {
    
    Node root;

    Binary_Tree(int data){
        root = new Node(data);
        root.left = root.right = null;
    }

    public void inOrderTraversalRecursive(Node iterator){
        if(iterator==null){
            return;
        }
        // a type of DFS where we have left-> root-> right;
        inOrderTraversalRecursive(iterator.left);
        System.out.println(iterator.data);
        inOrderTraversalRecursive(iterator.right);
    }

    public void inOrderTraversalStackBased(){
        Stack<Node> stack = new Stack<>();
        Node curr = root;

        //process nodes
        while(curr!=null || !stack.isEmpty()){
            // push all element of left tree
            while(curr!=null){
                stack.push(curr);
                curr= curr.left;
            }

            // process element then move right by taking it from stack
            curr = stack.pop();
            System.out.println("->"+curr.data);
            curr = curr.right;
        }
    }

    public void preOrderTraversal(Node curr){
        if (curr==null){
            return;
        }
        System.out.println("->"+curr.data);
        preOrderTraversal(curr.left);
        preOrderTraversal(curr.right);
    }

    public void preOrderTraversalStackApproach(){
        Stack<Node> stack = new Stack<>();
        stack.add(root);

        while(!stack.isEmpty()){
            Node curr = stack.pop();
            System.out.println("->"+curr.data);

            //right first so left is processed first
            if(curr.right!=null){
                stack.push(curr.right);
            }
            if(curr.left!=null){
                stack.push(curr.left);
            }
        }
    }

    public void postOrderTraversal(Node curr){
        if(curr==null){
            return;
        }
        postOrderTraversal(curr.left);
        postOrderTraversal(curr.right);
        System.out.println(curr.data);
    }

    public void postOrderTraversalStackApproach(){
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        if(root==null){
            return;
        }

        stack1.push(root);

        while(!stack1.isEmpty()){
            Node curr = stack1.pop();

            stack2.push(curr);
            if(curr.right!=null){
                stack2.push(curr.right);
            }
            if(curr.left!=null){
                stack2.push(curr.left);
            }
        }

        while(!stack2.isEmpty()){
            Node curr = stack2.pop();
            System.out.println(curr.data);
        }
    }

    public void levelOrderTraversal(){
        if( root == null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node curr = q.poll();
            System.out.println(curr.data);
            if(curr.left!=null){
                q.add(curr.left);
            }
            if(curr.right!=null){
                q.add(curr.right);
            }
        }

    }
}

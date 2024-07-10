package gitDSALGO.tree;

import java.util.*;

public class Tree {

        Node root;

        Tree(){
            this.root= null;
        }

        public void insert(int data){
            Node node = new Node(data);
            if(root==null){
                root=node;
            }else {
                recursiveInsert(root, data);
            }
        }

        public void recursiveInsert(Node node, int data){
            if(node.data > data){
                if(node.left==null){
                    node.left = new Node(data);
                }else {
                    recursiveInsert(node.left, data);
                }
            }else if(node.data < data){
                if(node.right==null){
                    node.right = new Node(data);
                }else {
                    recursiveInsert(node.right, data);
                }
            }
        }

        public void inOrderTraversal(Node node) {
            if (node != null) {
                inOrderTraversal(node.left);
                System.out.println(node.data + "=>");
                inOrderTraversal(node.right);
            }
        }

        public void preOrderTraversal(Node node){
            if(node!=null){
                System.out.println(node.data+"=>");
                preOrderTraversal(node.left);
                preOrderTraversal(node.right);
            }
        }

        public void postOrderTraversal(Node node){
            if(node!=null){
                postOrderTraversal(node.left);
                postOrderTraversal(node.right);
                System.out.println(node.data+"=>");
            }
        }

        public void breathFirstSearch(Node node){
            //Create queue
            //while q is not empty 
            //poll element
            //add left substree if not null
            //add right substree if not null
            Queue<Node> q = new LinkedList<>();
            q.add(node);
            while(!q.isEmpty()){

                Node tempNode = q.poll();
                System.out.println(tempNode.data);

                if(tempNode.left!=null){
                    q.add(tempNode.left);
                }
                if(tempNode.right!=null){
                    q.add(tempNode.right);
                }
            }
        }

        public void printTree(String order){
            if(order.equals("Inorder")){
                inOrderTraversal(root);
            }else if(order.equals("preOrder")){
                preOrderTraversal(root);
            }else if(order.equals("postOrder")){
                postOrderTraversal(root);
            }else if(order.equals("BFS")){
                breathFirstSearch(root);
            }
        }
    

    public static void main(String[] args) {
        
        Tree tree = new Tree();
        tree.insert(8);
        tree.insert(7);
        tree.insert(12);
        tree.insert(15);
        tree.insert(2);
        tree.insert(5);
        tree.printTree("BFS");
    }
}

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

        public Node delete(Node node, int data){
            if(node == null){
                return node;
            }
            if(node.data < data){
                node.right  = delete(node.right, data);
            }else if(node.data > data){
                node.left = delete(node.left, data);
            }else {
                    //no child
                    if(node.left==null){
                        return node.right;
                    }else if(node.right ==  null){
                        return node.left;
                    }
                    // two child => return inorder successor 
                    node.data = minValue(node.right);
                    
                    node.right = delete(node.right, node.data);
            }

            return node;
        }


        public int minValue(Node root){
            int minValue = root.data;
            while(root.left!=null){
                minValue = root.left.data;
                root=root.left;
            }
            return minValue;
        }



        public boolean searchValueInBST(Node node, int key){
            if(node.data == key){
                return true;
            }else if(node.data < key){
                if(node.right!=null) return searchValueInBST(node.right, key);
                else return false;
            }else{
                if(node.left!=null) return searchValueInBST(node.left, key);
                else return false;
            }
        }

        public boolean search(int key){
            return searchValueInBST(this.root, key);
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
            if(order.equals("IN")){
                inOrderTraversal(root);
            }else if(order.equals("PRE")){
                preOrderTraversal(root);
            }else if(order.equals("POST")){
                postOrderTraversal(root);
            }else if(order.equals("BFS")){
                breathFirstSearch(root);
            }
        }
    

    public static void main(String[] args) {
        
        Tree tree = new Tree();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        // tree.printTree("IN");

        System.out.println("If exist : - "+tree.search(70));
        tree.root = tree.delete(tree.root, 70);
        System.out.println("If exist : - "+tree.search(70));
        // tree.inOrderTraversal(tree.root);   
    }
}

package gitDSALGO.Queue.BasicImpl;

import gitDSALGO.Queue.*;

public class QueueMain {

    public static void main(String[] args) {
        
        Queue q = new QueueImpl();

        q.push(5);
        q.push(14);
        q.push(7);
        
        System.out.println("========= Queue ========>");
        q.printStack();

        System.out.println("========== size =======>");
        System.out.println(q.size());

        System.out.println("========== Top =======>");
        System.out.println(q.top());

        System.out.println("========== Pop =======>");
        try {
            System.out.println(q.pop());
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        

        System.out.println("========= Queue ========>");
        q.printStack();
    }

}

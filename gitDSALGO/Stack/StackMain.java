package gitDSALGO.Stack;

import gitDSALGO.Stack.*;
public class StackMain {
    
    public static void main(String[] args)  {
        
        Stack si = new StackImpl();

        si.push(1);
        si.push(5);
        si.push(7);

        System.out.println("========= Stack ========>");
        si.printStack();

        System.out.println("========== Size =======>");
        System.out.println(si.size());

        System.out.println("========== Top =======>");
        System.out.println(si.top());

        System.out.println("========== Pop =======>");
        try {
            System.out.println(si.pop());
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        

        System.out.println("========= Stack ========>");
        si.printStack();

    }
}

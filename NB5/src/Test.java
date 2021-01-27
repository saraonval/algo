/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author saraonval
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayListStack<String> stack = new ArrayListStack<String>();
        
        stack.push("Domain Name System");
        stack.push("Algorithms And Datastructures");
        stack.push("Network Security");
        stack.push("Mobile Applications And Wireless Systems");
        
        // peek
        System.out.println(stack.peek());
        
        // empty
        System.out.println(stack.empty());
        
        while(!stack.empty()) {
            // pop
            System.out.println(stack.pop());
        }
        
    }
    
}

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
        
        ArrayStack<String> stack = new ArrayStack<String>();
        
        // push
        System.out.println("push:");
        System.out.println(stack.push("Domain Name System"));
        System.out.println(stack.push("Algorithms And Datastructures"));
        System.out.println(stack.push("Network Security"));
        System.out.println(stack.push("Mobile Applications And Wireless Systems"));
        
        // peek(n)
        System.out.println("\npeek(2):");
        System.out.println(stack.peek(2));
        
        // size
        System.out.println("\nsize:");
        System.out.println(stack.size());
        
        // peek
        System.out.println("\npeek:");
        System.out.println(stack.peek());
        
        // empty
        System.out.println("\nempty:");
        System.out.println(stack.empty());
        
        // pop
        System.out.println("\npop:");
        System.out.println(stack.pop());
        
        //flush
        System.out.println("\nflush:");
        System.out.println(stack.flush());
        
    }
    
}

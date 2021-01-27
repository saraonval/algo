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
        LinkedQueue<String> q = new LinkedQueue<String>();
        q.enqueue("blue");
        q.enqueue("red");
        q.enqueue("green");
        System.out.println(q.size());
        q.dequeue();
        System.out.println(q.size());
    }
    
}

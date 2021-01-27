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
        Dequeue<String> q = new Dequeue<String>();
        q.offerLast("red");
        q.offerLast("yellow");
        q.offerLast("blue");
        q.offerLast("green");
        System.out.println(q);
        //System.out.println(q.size());
        System.out.println(q.pollFirst());
        System.out.println(q);
        System.out.println(q.pollLast());
      // System.out.println(q.size());
        System.out.println(q);
        System.out.println(q.pollLast());
        System.out.println(q);
        System.out.println(q.pollFirst());
        System.out.println(q);
    }
    
}

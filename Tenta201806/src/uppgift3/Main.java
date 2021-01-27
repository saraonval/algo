/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uppgift3;

/**
 *
 * @author bfelt
 */
public class Main {

    public static void main(String[] args) {
        Heap h = new Heap();
        h.offer(82);
        h.offer(41);
        h.offer(24);
        h.offer(30);
        h.offer(4);
        h.offer(19);
        h.offer(91);
        h.offer(12);
        //System.out.println(h);valfritt men praktiskt
        int i;
        while ((i = h.poll()) != Integer.MAX_VALUE) {
            System.out.println(i);
        }
    }

}

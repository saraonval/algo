/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Iterator;

/**
 *
 * @author saraonval
 */
public class Test {

    public static void main(String[] args) {
        
        SingleLinkedList<String> list = new SingleLinkedList<String>();
        
        // O(n^2)
        for(int i=0; i<10; i++) {
            list.add("Sträng "+ i);
        }
        
        Iterator<String> iter = list.iterator();
        // O(n)
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
        
    }
    
}

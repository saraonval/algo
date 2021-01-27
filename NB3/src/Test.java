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
        
        
        // ”Gilgamesh” -> ”löper” -> ”på” -> ”stäppen”
        Node node4 = new Node("stäppen", null);
        Node node3 = new Node("på", node4);
        Node node2 = new Node("löper", node3);
        Node node1 = new Node("Gilgamesh", node2);
        //Node head = new Node(null, node1);

        Node node = node1;
        
        // O(n)
        while(node != null) {
            System.out.println(node.data);
            node = node.next;
        }
        
        // Ta bort
        node2.next = node4;
        
        node = node1;
        while(node != null) {
            System.out.println(node.data);
            node = node.next;
        }
        
        
    }
    
}

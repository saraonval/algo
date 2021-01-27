/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author saraonval
 */
public class Node { 
    public String data; 
    public Node next;
    
    public Node(String data, Node next) {
        this.data = data;
        this.next = next;
    }
}
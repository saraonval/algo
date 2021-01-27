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

    public static void main(String[] args) {
        IntList list = new IntList(5);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        
        printList(list);
        
        list.remove(3);
        
        printList(list);
        
        list.add(21);
        
        printList(list);
    }
    
        
    public static void printList(IntList list) {
        System.out.println("***** ***** *****");
        System.out.println("Size: " + list.size());
        for(int i=0; i<list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("***** ***** *****");
    }
    
}

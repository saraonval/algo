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
        
        SingleLinkedList<String> list = new SingleLinkedList<String>();
        for(int i= 0; i<4; i++){
            list.add("e" + i);
        }
        System.out.println(list);
        list.remove(0);
        System.out.println(list);
        list.add(0, "först");
        list.add("sist");
        System.out.println(list);
    }
    
}

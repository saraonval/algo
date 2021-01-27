/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programming_1_2;

import java.util.ArrayList;

/**
 *
 * @author saraonval
 */
public class Programming_1_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("Sara");
        list.add("Gabriella");
        list.add("Bella");
        
        printList(list);
        
        replace(list, "Gabriella", "Sara");
        
        printList(list);
        
        delete(list, "Sara");
        
        printList(list);
    }
    
    /** Replaces each occurrence of olditem in aList with newitem.*/ 
    public static void replace(ArrayList<String> aList, String oldItem, String newltem) {
        for(int i=0; i<aList.size(); i++) {
            if(aList.get(i).equals(oldItem)) {
                aList.set(i, newltem);
                return;
            }
        }
    }
    
    /** De1etes the first occurrence of target in aList. */
    public static void delete(ArrayList<String> aList, String target) {
        for(int i=0; i<aList.size(); i++) {
            if(aList.get(i).equals(target)) {
                aList.remove(i);
                return;
            }
        }
    }
    
    public static void printList(ArrayList list) {
        System.out.println(list.size());
        for(int i=0; i<list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
    
}

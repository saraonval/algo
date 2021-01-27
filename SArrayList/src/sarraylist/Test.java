/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sarraylist;

/**
 *
 * @author saraonval
 */
public class Test {
    
    /**
    * @param args the command line arguments
    */
    public static void main(String[] args) {
        
        SArrayList<String> list = new SArrayList<>();
        list.add("Hello");
        list.add("Hej");
        list.add("Hola");
        list.add("Shlomo");
        list.add("Marhaba");
        list.add("Bonjour");
        
        System.out.println(list);
        //printList(list);
        
        list.remove(2);
        
        //printList(list);
        System.out.println(list);
        
        //System.out.println(list.indexOf("Bonjour"));
        
        
    }
    
    public static void printList(SArrayList list) {
        //System.out.println(list.size());
        for(int i=0; i<list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
    
}

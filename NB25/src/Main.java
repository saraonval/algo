/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author saraonval
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        HashTableBucket htb = new HashTableBucket(2);
        String[] colors = {"Blue", "Red", "Yellow", "Green", "Pink", "Purple", "Black", "Grey", "White", "Gold"};
        for(int i=0; i<colors.length; i++) {
            htb.put(i, colors[i]);
        }
        System.out.println("toString() default");
        System.out.println(htb);
        System.out.println();
        System.out.println("toString() variation");
        System.out.println(htb.toString2());
        
        System.out.println("Remove: " + htb.remove(0));
        System.out.println("Remove (null): " + htb.remove(10));
        System.out.println(htb);

    }
    
}

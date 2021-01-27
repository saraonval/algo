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
        
        /*
        HashTableBucket htb = new HashTableBucket(2);
        String[] colors = {"Blue", "Red", "Yellow", "Green", "Pink", "Purple", "Black", "Grey", "White", "Gold"};
        for(int i=0; i<colors.length; i++) {
            htb.put(i, colors[i]);
        }
        System.out.println("toString() default");
        System.out.println(htb);
        System.out.println();
        
        System.out.println("Remove 0: " + htb.remove(0));
        System.out.println("Remove 10 (null): " + htb.remove(10));
        System.out.println(htb);

        for(int i=0; i<colors.length; i++) {
            htb.put(i+10, colors[i]);
        }
        
        System.out.println(htb);
        */
        
        HashTableBucket htb = new HashTableBucket(2);
        String[] foods = {"pizza", "hamburger", "pasta", "potato", "rice", "fries", "cake", "toast"};
        for(int i=0; i<foods.length; i++) {
            htb.put(i, foods[i]);
        }
        System.out.println(htb);
        System.out.println("Remove 2: " + htb.remove(2));
        System.out.println(htb);
        System.out.println("Remove 0: " + htb.remove(0));
        System.out.println(htb);
        System.out.println("Get 0: " + htb.get(0));
        System.out.println("Get 5: " + htb.get(5));
        System.out.println("Put 8: " + htb.put(8, "cheeseburger"));
        System.out.println("Put 0: " + htb.put(0, "chickenburger"));
        System.out.println("\n" + htb);
    }
    
}

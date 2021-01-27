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
    
    public static void main(String[] args) {
        
        HashTableOpen<Integer, String> hto = new HashTableOpen();
        String[] foods = {"pizza", "hamburger", "pasta", "potato", "rice", "fries", "cake", "toast"};
        for(int i=0; i<foods.length; i++) {
            hto.put(i, foods[i]);
        }
        System.out.println(hto);
        System.out.println("Remove 2: " + hto.remove(2));
        System.out.println(hto);
        System.out.println("Remove 0: " + hto.remove(0));
        System.out.println(hto);
        System.out.println("Get 0: " + hto.get(0));
        System.out.println("Get 5: " + hto.get(5));
        System.out.println("Put 8: " + hto.put(8, "cheeseburger"));
        System.out.println("Put 0: " + hto.put(0, "chickenburger"));
        System.out.println("\n" + hto);
    }
}

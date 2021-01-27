
import java.util.Scanner;

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
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        /*for(int i=0; i<7; i++) {
            bst.add(i+1);
        }*/
        bst.add(4);
        bst.add(3);
        bst.add(2);
        bst.add(1);
        bst.add(5);
        bst.add(6);
        bst.add(7);
        System.out.println("In-Order: " + bst.toString());
        System.out.println("Pre-Order: " + bst.toStringPreOrder());
        System.out.println("Post-Order: " + bst.toStringPostOrder());
    }
    
}

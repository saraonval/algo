
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
        Scanner scanner = new Scanner(System.in);
        BinarySearchTree<String> bst = new BinarySearchTree<>();
        for(int i=0; i<7; i++) {
            String word = scanner.nextLine();
            bst.add(word);
        }
        System.out.println(bst);
    }
    
}


import javax.swing.JOptionPane;

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
    /*
    public static void main(String[] args) {
        BinarySearchTree<PhoneEntry> bst = new BinarySearchTree<PhoneEntry>();
        while (true) {
            String fName = JOptionPane.showInputDialog("Förnamn:");
            if (fName.equals("")) {
                break;
            }
            String lName = JOptionPane.showInputDialog("Efternamn:");
            String number = JOptionPane.showInputDialog("Nummer:");
            bst.add(new PhoneEntry(fName, lName, number));
        }
        while (true) {
            String fName = JOptionPane.showInputDialog("Förnamn:");
            if (fName.equals("")) {
                break;
            }
            String lName = JOptionPane.showInputDialog("Efternamn:");
            System.out.println(bst.find(new PhoneEntry(fName, lName, "")));
        }
    }
*/
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for(int i=0; i<10; i++) {
            bst.add(i+1);
        }
        System.out.println(bst.toString());
        System.out.println("Find 1: " +bst.find(1));
        System.out.println("Add 1 again: " + bst.add(1));
        System.out.println("Remove 3: " +  bst.delete(3));
        System.out.println(bst.toString());
        
    }
}

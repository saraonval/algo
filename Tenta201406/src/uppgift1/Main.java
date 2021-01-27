package uppgift1;

import javax.swing.JOptionPane;

public class Main {

    public static void buildTree(BinarySearchTree<String> b) {
        b.add("H");
        b.add("B");
        b.add("N");
        b.add("A");
        b.add("E");
        b.add("C");
        b.add("F");
        b.add("D");
    }

    public static void main(String[] args) {
        BinarySearchTree<String> bst = new BinarySearchTree<String>();
        buildTree(bst);
        System.out.println(bst.numNodes() + " " + bst.height());

    }

}

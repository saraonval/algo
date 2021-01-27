package uppgift3;

public class Main {

    public static void buildTree(BinarySearchTree<String> b) {
        b.add("H");
        b.add("C");
        b.add("I");
        b.add("E");
        b.add("D");
        b.add("F");
        b.add("A");
    }

    public static void main(String[] args) {

        BinarySearchTree<String> bst = new BinarySearchTree<String>();
        buildTree(bst);
        System.out.println(bst.numberParents2Child());
        System.out.println(bst.max());
    }

}

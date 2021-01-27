package uppgift2;

public class Main {

    public static void main(String[] args) {

        BinarySearchTree<String> bst = new BinarySearchTree<>();
        System.out.println(bst.max());
        System.out.println(bst.numberOfLeaves());
        bst.add("L");
        bst.add("D");
        bst.add("F");
        bst.add("O");
        bst.add("R");
        bst.add("N");
        bst.add("P");
        bst.add("U");
        bst.add("C");
        bst.add("A");
        System.out.println(bst.max());
        System.out.println(bst.numberOfLeaves());
        bst = new BinarySearchTree<>();
        bst.add("L");
        bst.add("D");
        bst.add("B");
        bst.add("F");
        bst.add("E");
        bst.add("O");
        bst.add("N");
        bst.add("M");
        bst.add("S");
        System.out.println(bst.secondMax());
    }

}

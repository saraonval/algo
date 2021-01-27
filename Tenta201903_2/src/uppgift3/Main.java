package uppgift3;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree<String> bst = new BinarySearchTree<>();
        bst.add("H");
        bst.add("B");
        bst.add("N");
        bst.add("A");
        bst.add("E");
        bst.add("C");
        bst.add("F");
        bst.add("D");
        System.out.println(bst.toString());//ger A B C D E F H N
        System.out.println(bst.toString("B"));//ger A B C D E F, OBS rita trädet på papper!
        System.out.println(bst.toString("E"));//ger C D E F
    }
}

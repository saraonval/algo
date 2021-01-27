
package uppgift3;

public class Main {


	public static void main(String[] args) {

	BinarySearchTree<Integer> bst = new BinarySearchTree<>();
	bst.add(20);
        bst.add(10);
        bst.add(30);
        bst.add(5);
        bst.add(15);
        bst.add(40);
        bst.add(3);
        bst.add(12);
        bst.add(35);
        bst.add(45);
        bst.add(11);
        bst.add(14);
        bst.add(33);
        bst.add(37);
        bst.add(48);

        System.out.println(bst.height());
        System.out.println(bst.nrNodesWith2children());
        System.out.println(bst.nrNodesWith2grandchildren());
		  
	}

}

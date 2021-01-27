package uppgift4;

public class Main {


	public static void main(String[] args) {

            BinarySearchTree<PhoneEntry> bst = new BinarySearchTree<>();
            
            bst.add(new PhoneEntry("Per","Ek","1234"));
            bst.add(new PhoneEntry("Arman","Lotfi","1111"));
            bst.add(new PhoneEntry("Mamo","Tosti","2222"));
            bst.add(new PhoneEntry("Malin","Lund","3333"));
            bst.add(new PhoneEntry("Lubi","Kahn","4444"));
            bst.add(new PhoneEntry("Mariam","Tosti","5555"));
            System.out.println(bst.height());
            System.out.println(bst.find(new PhoneEntry("Mamo","Tosti","")));
		  
	}

}

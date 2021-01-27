/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author saraonval
 */
public class BinarySearchTree<E extends Comparable<E>> {

    private static class Node<E> {

        private E data;
        private Node<E> left, right;

        private Node(E data) {
            this.data = data;
            left = right = null;
        }

        @Override
        public String toString() {
            return data.toString();
        }

    }

    // Datamedlemmar
    private Node<E> root;
    private E deletedData;

    // Konstruktor
    public BinarySearchTree() {
        root = null;
    }
    
    
    //
    //
    //
    
    
    // Wrapper
    public int getNumberOfLeaves() {
        return getNumberOfLeaves(root);
    }
    
    private int getNumberOfLeaves(Node<E> node) {
        
        // Om den är null
        if (node == null) {
            return 0;
        }
        // Om den inte har barn
        if (node.left == null && node.right == null) {
            return 1;
        }
        // Rekursion, tills den inte har barn
        // IF (RIGHT != NULL || LEFT != NULL)
        return getNumberOfLeaves(node.left) + getNumberOfLeaves(node.right);
        
    }
    
    // Wrapper
    public int getNumberOfNodes() {
        return getNumberOfNodes(root);
    }
    
    private int getNumberOfNodes(Node<E> node) {
        // Om den är null
        if (node == null) {
            return 0;
        }
        // Om den inte har barn
        if (node.left == null && node.right == null) {
            return 1;
        }
        // Rekursion, tills den inte har barn
        return getNumberOfNodes(node.left) + getNumberOfNodes(node.right) + 1;
    }

    //
    //
    //
    

    // Rotnod vid första anropet, men rekursivt ropar till subträden
    // Besök först trädets vänstra del, sedan noden själv och sist trädets högra del.
    private void inOrder(Node<E> node, StringBuilder sb) {
        if (node != null) {
            inOrder(node.left, sb);
            sb.append(": " + node.toString());
            inOrder(node.right, sb);
        }
    }
    
    // Besök först noden själv, sedan trädets vänstra del och sist trädets högra del.
    private void preOrder(Node<E> node, StringBuilder sb) {
        if (node != null) {
            sb.append(": " + node.toString());
            preOrder(node.left, sb);
            preOrder(node.right, sb);
        }
    }
    
    // Besök först trädets vänstra del, sedan trädets högra del och sist noden själv.
    private void postOrder(Node<E> node, StringBuilder sb) {
        if (node != null) {
            postOrder(node.left, sb);
            postOrder(node.right, sb);
            sb.append(": " + node.toString());
        }
    }

    // Skriva inOrder, från misnt till störst om man följer nycklarna
    public String toString() {
        StringBuilder sb = new StringBuilder();
        inOrder(root, sb);
        return sb.toString();
    }
    
    public String toStringPreOrder() {
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        return sb.toString();
    }
    
    public String toStringPostOrder() {
        StringBuilder sb = new StringBuilder();
        postOrder(root, sb);
        return sb.toString();
    }

    private boolean add(E data, Node<E> node) {
        // Kolla om data finns i den nod som kommer in i metoden
        // Om nyckeln redan finns, ska det inte gå att lägga till
        if (data.compareTo(node.data) == 0) {
            return false;
        } // Kolla om nyckeln är mindre än nyckeln för den nod vi står i
        else if (data.compareTo(node.data) < 0) {
            // Då ska data in på vänster sida av trädet
            if (node.left == null) {
                node.left = new Node<E>(data);
                return true;
            } // Om det inte är null, betyder det att det finns ett vänstra träd
            else {
                // Anropa add rekursivt, fast skicka in vänstra noden
                return add(data, node.left);
            }
        } // Om datat ska in till höger träd
        else {
            if (node.right == null) {
                node.right = new Node<E>(data);
                return true;
            } else {
                return add(data, node.right);
            }
        }
    }

    // Wrapper
    public boolean add(E data) {
        if (root == null) {
            root = new Node<E>(data);
            return true; // I ett binärt sökträd lyckas man inte alltid lägga till data
            // Om det redan finns data med samma nyckel kommer det misslyckas
        } else {
            return add(data, root);
        }
    }

    private E find(E target, Node<E> node) {
        if (node == null) {
            return null;
        }
        // Om datat ligger i noden vi fick in 
        if (target.compareTo(node.data) == 0) {
            return node.data;
        }
        // Om datat har en nyckel som är mindre än noden vi står i
        if (target.compareTo(node.data) < 0) {
            // Leta vidare i vänstra trädet
            return find(target, node.left);
        }
        // Annars leta vidare i högra trädet
        return find(target, node.right);
    }

    // Wrapper
    public E find(E target) {
        return find(target, root);
    }
    
    private Node<E> delete(E target, Node<E> node) {
        if (node == null) { // target finns inte i trädet
            deletedData = null;
            return null;
        }
        else {
            if(target.compareTo(node.data) < 0) { // target finns i vänstra trädet
                node.left = delete(target, node.left); // om det finns
                return node;
            }
            else if(target.compareTo(node.data) > 0) { // target i högra trädet
                node.right = delete(target, node.right);
                return node;
            }
            // target finns i node!
            else {
                deletedData = node.data; // lagrar data att returnera
                // nu ska vi bygga om trädet
                
                if(node.left == null) { // noden som ska bort saknar vänster träd
                    return node.right;
                }
                
                else if(node.right == null) { // noden som ska bort saknar höger träd
                    return node.left;
                }
                
                else { // noden vi ska ta bort har två barn
                    // SVÅRT
                    Node<E> nodeToMove = node.right, parentNodeToMove = node;
                    
                    if(nodeToMove.left == null) { // högra barnet har inget vänsterbarn
                        return nodeToMove;
                    }
                    
                    // högra barnet har vänsterbarn
                    while(nodeToMove.left != null) {
                        parentNodeToMove = nodeToMove;
                        nodeToMove = nodeToMove.left;
                    }
                    
                    parentNodeToMove.left = nodeToMove.right;
                    node.data = nodeToMove.data;
                    return node;
                }
            }
        }
    }
    
    // Wrapper
    public E delete(E target) {
        root = delete(target, root); // return blir vårt nya träd
        return deletedData;
    }

}

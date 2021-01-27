package uppgift2;

public class BinarySearchTree<E extends Comparable<E>> {

    private static class Node<E> {

        private E data;
        private Node<E> left, right;

        private Node(E d) {
            data = d;
            left = right = null;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    private Node<E> root;

    public BinarySearchTree() {
        root = null;
    }

    private boolean add(E data, Node<E> node) {
        if (data.compareTo(node.data) == 0) {
            return false;
        } else if (data.compareTo(node.data) < 0) {
            if (node.left == null) {
                node.left = new Node<>(data);
                return true;
            } else {
                return add(data, node.left);
            }
        } else if (node.right == null) {
            node.right = new Node<>(data);
            return true;
        } else {
            return add(data, node.right);
        }
    }

    public boolean add(E data) {
        if (root == null) {
            root = new Node<>(data);
            return true;
        } else {
            return add(data, root);
        }
    }

    public int numberOfLeaves() {
        return numberOfLeaves(root);
    }
    
    private int numberOfLeaves(Node<E> node) {
        if (node == null) {
            return 0;
        }
        
        if (node.left == null && node.right == null) {
            return 1 + numberOfLeaves(node.left) + numberOfLeaves(node.right);
        }
        
        return numberOfLeaves(node.left) + numberOfLeaves(node.right);
    }

    public E max() {
        return max(root);
    }
    
    private E max(Node<E> node) {
        if (node == null) {
            return null;
        }
        
        if(node.right == null) {
            return node.data;
        }
        
        return max(node.right);
    }

    public E secondMax() {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return null;
        }
        return secondMax(root);
    }
    
    private E secondMax(Node<E> node) {
        if (node.right.right == null) {
            return node.data;
        }
        return secondMax(node.right);
    }

}

package uppgift4;

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

    public int height() {
        return height(root);
    }
    
    private int height(Node<E> node) {
        if (node == null) {
            return 0;
        }
        
        return 1 + Math.max(height(node.left), height(node.right));
    }


    public E find(E target) {
        return find(target, root);
    }

    private E find(E target, Node<E> node) {
        if(node == null) {
            return null;
        }
        if(target.compareTo(node.data) == 0) {
            return node.data;
        }
        if(target.compareTo(node.data) < 0) {
            return find(target, node.left);
        }
        return find(target, node.right);
    }

}

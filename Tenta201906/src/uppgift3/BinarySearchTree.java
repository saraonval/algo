package uppgift3;

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
        
        return  1 + Math.max(height(node.left), height(node.right));
    }

    public int nrNodesWith2children() {
        return nrNodesWith2children(root);
    }
    
    private int nrNodesWith2children(Node<E> node) {
        if (node == null) {
            return 0;
        }
        
        if (node.left == null) {
            return nrNodesWith2children(node.right);
        }
        
        if (node.right == null) {
            return nrNodesWith2children(node.left);
        }
        
        return 1 + nrNodesWith2children(node.left) + nrNodesWith2children(node.right);
    }

    public int nrNodesWith2grandchildren() {
        return nrNodesWith2grandchildren(root);
    }
    
    private int nrNodesWith2grandchildren(Node<E> node) {
        if (node == null) {
            return 0;
        }
        if(nrOfChildren(node.left) + nrOfChildren(node.right) == 2) {
            return 1 + nrNodesWith2grandchildren(node.left) + nrNodesWith2grandchildren(node.right);
        }
        return nrNodesWith2grandchildren(node.left) + nrNodesWith2grandchildren(node.right);
    }
    
    private int nrOfChildren(Node<E> node) {
        if (node == null) {
            return 0;
        }
        int nrOfChildren = 0;
        if (node.left != null) {
            nrOfChildren++;
        }
        if (node.right != null) {
            nrOfChildren++;
        }
        return nrOfChildren;
    }

}

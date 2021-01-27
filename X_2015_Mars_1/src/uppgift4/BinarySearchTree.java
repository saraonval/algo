package uppgift4;

import java.util.*;

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
                node.left = new Node<E>(data);
                return true;
            } else {
                return add(data, node.left);
            }
        } else if (node.right == null) {
            node.right = new Node<E>(data);
            return true;
        } else {
            return add(data, node.right);
        }
    }

    public boolean add(E data) {
        if (root == null) {
            root = new Node<E>(data);
            return true;
        } else {
            return add(data, root);
        }
    }

    public E find(E target) {
        return find(target, root);
    }
    
    private E find(E target, Node<E> node) {
        if (node == null) {
            return null;
        }
        if (target.compareTo(node.data) == 0) {
            return node.data;
        }
        if (target.compareTo(node.data) < 0) {
            return find(target, node.left);
        }
        return find(target, node.right);
    }

    public void printTree() {
        Queue<Node<E>> q = new LinkedList<>();
        Queue<Integer> level = new LinkedList<>();
        printTree(root, q, level, 1);
    }
    
    private void printTree(Node<E> node, Queue<Node<E>> q, Queue<Integer> level, int l) {
        
        System.out.print(node + ", ");
        
        if (node != null) {
            q.offer(node.left);
            level.offer(l+1);
            q.offer(node.right);
            level.offer(l+1);
        }
        
        while (!q.isEmpty()) {
            if (level.poll() > l) {
                System.out.println("");
                l++;
            }
            printTree(q.poll(), q, level, l);
        }
        
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author saraonval
 */
// För att det ska funka med HashTable:
// Lägg iterator() under Itr klassen
// Ta bort size variabeln
public class SingleLinkedList<E> implements Iterable<E> {

    private static class Node<E> {

        private E data;
        private Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head;

    public SingleLinkedList() {
        head = null;
    }

    public int size() {
        return size(head);
    }

    private int size(Node<E> node) {
        if (node == null) {
            return 0;
        }
        return size(node.next) + 1;
    }

    public void add(int index, E item) {

        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }

        // Lägg till först i listan
        if (index == 0) {
            addFirst(item);
        } else {
            Node<E> node = getNode(index - 1); // Hämta noden innan
            addAfter(node, item);
        }

    }

    public boolean add(E item) {
        add(size(), item);
        return true;
    }

    public E get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }

        Node<E> node = getNode(index);
        return node.data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> p = head;
        if (p != null) {
            while (p.next != null) {
                sb.append(p.data.toString());
                sb.append(" ==> ");
                p = p.next;
            }
            sb.append(p.data.toString()); // sista noden
        }
        sb.append("]");
        return sb.toString();
    }

    private void addFirst(E item) {
        head = new Node<>(item, head);
        // Skapa en ny nod och låt den peka på första noden (det som head pekar på)
        // Och flytta head-pekare
    }

    // Returnerar null om noden saknas
    private Node<E> getNode(int index) {
        Node<E> node = head;
        for (int i = 0; i < index && node != null; i++) {
            node = node.next;
        }
        return node;
    }

    private void addAfter(Node<E> node, E item) {
        node.next = new Node<>(item, node.next);
    }

    private class Itr implements Iterator<E> {

        private Node<E> current;
        private Node<E> previous;
        private Node<E> previous2;
        private boolean removeAllowed;

        public Itr(Node<E> start) {
            this.current = start;   //current = head
            this.previous = null;
            this.previous2 = null;
            this.removeAllowed = false;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }
        @Override
        public E next() {
            if (current == null) {
                throw new NoSuchElementException();
            }
            E returnValue = current.data;
            previous2 = previous;
            previous = current;
            current = current.next;
            removeAllowed = true;
            return returnValue;
        }

        @Override
        public void remove() {
            if (previous == null || removeAllowed == false) {
                throw new IllegalStateException();
            }
            if (previous2 == null) {
                head = current;
                previous = null;
            } else {
                previous2.next = current;
                previous = previous2;
            }
            removeAllowed = false;
        }
    }

    /*
    private class Itr implements Iterator<E> {
        Node<E> current;
        
        public Itr(Node<E> start) {
            current = start;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if(current == null) {
                throw new NoSuchElementException();
            }
            
            E returnValue = current.data;
            current = current.next;
            return returnValue;
        }
        
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    } */

    @Override
    public Iterator<E> iterator() {
        return new Itr(head);
    }

}

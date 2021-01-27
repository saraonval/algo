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
public class SingleLinkedList<E> implements Iterable {
    
    private static class Node<E> {
        private E data;
        private Node<E> next;
        
        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }
    
    private Node<E> head;
    private int size;
    
    public SingleLinkedList() {
        head = null;
        size = 0;
    }
    
    public void add(int index, E item) {
        
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        
        // Lägg till först i listan
        if(index == 0) {
            addFirst(item);
        }
        else {
            Node<E> node = getNode(index-1); // Hämta noden innan
            addAfter(node, item);
        }
        
    }
    
    public boolean add(E item) {
        add(size, item);
        return true;
    }
    
    public E get(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        
        Node<E> node = getNode(index);
        return node.data;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        Node<E> p = head;
        if(p != null) {
            while(p.next != null) {
                sb.append(p.data.toString());
                sb.append(" ==> ");
                p = p.next;
            }
            sb.append(p.data.toString()); // sista noden
        }
        sb.append("]");
        return sb.toString();
    }
    
    public Iterator<E> iterator() {
        return new Itr(head);
    }
    
    private void addFirst(E item) {
        head = new Node<E>(item, head); 
        // Skapa en ny nod och låt den peka på första noden (det som head pekar på)
        // Och flytta head-pekare
        
        size++;
    }
    
    // Returnerar null om noden saknas
    private Node<E> getNode(int index) {
        Node<E> node = head;
        for(int i=0; i<index && node!=null; i++) {
            node = node.next;
        }
        return node;
    }
    
    private void addAfter(Node<E> node, E item) {
        node.next = new Node<E>(item, node.next);
        size++;
    }
    
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
    }
    
}

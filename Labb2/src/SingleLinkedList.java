import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Sara Onval
 */
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
    private Node<E> tail;
    private int size;

    public SingleLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(int index, E item) {
        
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        
        if (index == 0) {
            addFirst(item);
        } else if (index == size && size > 0) {
            addLast(tail, item);
        } else {
            Node<E> node = getNode(index - 1);   
            addAfter(node, item);
        }
        
        if (size == 1) {
            createTail();

        }
    }

    private void addLast(Node<E> node, E item) {
        tail.next = new Node<E>(item, null);
        tail = tail.next;
        size++;

    }

    private void createTail() {
        tail = getNode(size - 1);
    }

    public void addFirst(E item) {
        head
                = new Node<E>(item, head);
        size++;
    }

    private Node<E> getNode(int index) {  // retunera node
        Node<E> node = head;
        for (int i = 0; i < index && node != null; i++) {
            node = node.next;
        }
        return node;
    }

    private void addAfter(Node<E> node, E item) { 
        node.next
                = new Node<E>(item, node.next);
        size++;
    }

    public boolean add(E item) { // lagga till i slutet
        add(size, item);
        return true;
    }

    public E get(int index) {  // hämta data från index
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        if (size == index + 1) {

            return tail.data;
        }
        Node<E> node = getNode(index);
        return node.data;
    }

    public E remove(int index) {
        E result = null; // temp
        // 
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        // om fista plats de vill ha 
        if (index == 0) {
            result = head.data; // jag tar ut data från 1 platsen
            head = head.next;   // nu finns inte 1 platsen då  
        } else {
            Node<E> node = getNode(index - 1); 
            node.next = node.next.next;
        }

        size--;
        if (size == index && size > 0) {
            createTail();
        }
        return result; //hamta data från node some tabort
    }

    public int getSize() {
        return size;
    }

    public Iterator<E> iterator() {
        return new Itr(head);
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
            sb.append(p.data.toString());
        }
        sb.append("]");
        return sb.toString();
    }

    private class Itr implements Iterator<E> {//nested class – ligger i SingleLinkedList

        Node<E> current;

        public Itr(Node<E> start) {
            current = start;
        }

        @Override
        public boolean hasNext() { 
            return current != null;  //if current != null it mean no element to return
        }

        @Override
        public E next() {
            if (current == null) {
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
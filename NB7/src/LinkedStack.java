
import java.util.EmptyStackException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author saraonval
 */
public class LinkedStack<E> implements StackInt<E> {

    private static class Node<E> {
        private E data;
        private Node<E> next;
        
        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }
    
    private Node<E> top;

    public LinkedStack() {
        top = null;
    }
    
    @Override
    public E pop() {
        if(empty()) {
            throw new EmptyStackException();
        }
        else {
            E result = top.data;
            top = top.next;
            return result;
        }
    }

    @Override
    public E push(E obj) {
        top = new Node(obj, top);
        return obj;
    }

    @Override
    public E peek() {
        if(empty()) {
            throw new EmptyStackException();
        }
        else {
            return top.data;
        }
    }

    @Override
    public boolean empty() {
        return top == null;
    }
    
    public int size() {
        if(empty()) {
            return 0;
        }
                
        Node<E> p = top;
        int counter = 1;
        if(p != null) {
            while(p.next != null) {
                counter++;
                p = p.next;
            }
        }
        return counter;
    }
    
    public E peek(int n) {
        if(empty()) {
            throw new EmptyStackException();
        }
        
        if(n > size() || n <= 0) {
            throw new IndexOutOfBoundsException();
        }
        
        E element = null;
        
        Node<E> p = top;
        int counter = 0;
        if(p != null) {
            while(p.next != null) {
                if(counter == n) {
                    element = p.data;
                }
                counter++;
                p = p.next;
            }
        }
        
        return element;
    }
    
    public E flush() {
        Node<E> p = top;
        E element = null;
        if(p != null) {
            while(p.next != null) {
                p = p.next;
                element = pop(); 
            }
        }
        element = pop();
        return element;
    }
    
}

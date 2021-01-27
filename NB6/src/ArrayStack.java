
import java.util.Arrays;
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
public class ArrayStack<E> implements StackInt<E> {

    private E[] data;
    private int top;
    private int maxSize;
    
    public ArrayStack() {
        top = -1;   // !!!
        maxSize = 10;
        data = (E[]) new Object[maxSize];
    }
    
    @Override
    public E pop() {
        if(empty()) {
            throw new EmptyStackException();
        }
        return data[top--];
    }

    @Override
    public E push(E obj) {
        if(top == maxSize - 1) {
            reallocate();
        }
        top++;
        data[top] = obj;
        return obj;
    }

    @Override
    public E peek() {
        if(empty()) {
            throw new EmptyStackException();
        }  
        return data[top];
    }

    @Override
    public boolean empty() {
        return top == -1;
    }
    
    public int size() {
        return top+1;
    }
    
    public E peek(int n) {
        
        if(empty()) {
            throw new EmptyStackException();
        }
        
        if(n > top || n < 0) {
            throw new IndexOutOfBoundsException();
        }
        
        return data[n];
    }
    
    public E flush() {
        E last = data[top];
        while(!empty()) {
            last = pop();
        }
        return last;
    }
    
    private void reallocate() {
        maxSize *= 2;
        data = Arrays.copyOf(data, maxSize);
    }
    
}

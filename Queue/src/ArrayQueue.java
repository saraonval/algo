
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author saraonval
 */
public class ArrayQueue<E> extends AbstractQueue<E> implements Queue<E> {

    private int front, rear, size, maxSize;
    private E[] data;
    
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        size = 0;
        front = 0;
        rear = maxSize-1;
        data = (E[]) new Object[maxSize];
    }
    
    @Override
    public Iterator<E> iterator() {
        return new Iter();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean offer(E e) {
        if(size == maxSize) {
            reallocate();
        }
        rear = (rear+1) % maxSize;
        data[rear] = e;
        size++;
        return true;
    }

    @Override
    public E poll() {
        if(size == 0) {
            return null;
        }
        E element = data[front];
        front = (front+1) % maxSize;
        size--;
        return element;
    }

    @Override
    public E peek() {
        if(size == 0) {
            return null;
        }
        return data[front];
    }
    
    private void reallocate() {
        int newMaxSize = maxSize * 2;
        E[] newData = (E[]) new Object[newMaxSize];
        int j = front;
        for(int i=0; i<size; i++) {
            newData[i] = data[j];
            j = (j+1) % maxSize;
        }
        front = 0;
        rear = size-1;
        maxSize = newMaxSize;
        data = newData;
    }
    
    private class Iter implements Iterator<E> {

        private int index;
        private int count;
        
        public Iter() {
            index = front;
        }
        
        @Override
        public boolean hasNext() {
            return count < size; // vi har fortfarande element kvar
        }

        @Override
        public E next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            E returnValue = data[index];
            index = (index+1) % maxSize;
            count++;
            return returnValue;
        }

        @Override
        public void remove() {
            // Ska endast kunna gå att ta bort första elementet.
            throw new UnsupportedOperationException();        
        }
        
    }
    
}

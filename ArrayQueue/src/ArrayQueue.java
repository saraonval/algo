/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author saraonval
 */
public class ArrayQueue<E> {
    private int front, rear, size, maxSize;
    private E[] data;
    
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        size = 0;
        front = 0;
        rear = maxSize - 1;
        data = (E[]) new Object[maxSize];
    }
    
    public boolean offer(E element) { 
        
        if(size == maxSize) {
            reallocate();
        }
        
        rear = (rear+1) % maxSize; // Om rear = maxSize
        data[rear] = element;
        size++;
        return true;
        
    }
    
    public E peek() {
        if(size == 0) {
            return null;
        }
        return data[front];
    }
    
    public E poll() {
        if(size == 0) {
            return null;
        }
        else {
            E element = data[front];
            size--;
            front = (front+1) % maxSize; // Om front = maxSize
            return element;
        }
    }
    
    private void reallocate() {
        int newMaxSize = maxSize * 2;
        E[] newData = (E[]) new Object[newMaxSize];
        int j = front; // kan ligga mitt i
        for(int i=0; i<size; i++) {
            newData[i] = data[j];
            j = (j+1) % maxSize; // tar hänsyn till att j kan loopa
        }
        front = 0;
        rear = size-1;
        maxSize = newMaxSize;
        data = newData;
    }
    
}

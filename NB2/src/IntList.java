/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Arrays;

/**
 *
 * @author saraonval
 */
public class IntList {
    
    private int[] data;
    private int noOfElements;
    private int maxSize;
    
    /**
     * Constructs a new IntList.
     */
    public IntList(int initialCapacity) {
        noOfElements = 0;
        maxSize = initialCapacity;
        data = new int[maxSize];
    }
    
    /**
     * Adds a reference to anEntry at the end of the Intlist. 
     * Always returns true.
     * 
     * @param element
     * @return true
     */
    public boolean add(int element) {
        if(noOfElements == maxSize) {
            reallocate();
        }
        data[noOfElements] = element;
        noOfElements++;
        return true;
    }
    
    /**
     * Adds a reference to element, inserting it before the item at
     * position index.
     * 
     * @param index
     * @param element 
     */
    public void add(int index, int element) {
        if (index <= noOfElements && index >= 0) {

            if (noOfElements == maxSize) {
                reallocate();
            }

            // Skifta element ett steg åt höger
            // Shift data in elements from index to size - 1
            for (int i = noOfElements; i > index; i--) {
                data[i] = data[i-1];
            }
            
            // Insert the new item.
            data[index] = element;
            noOfElements++;

        }
        throw new ArrayIndexOutOfBoundsException(index);
    }
    
    /**
     * Returns a reference to the element at position index.
     * 
     * @param index
     * @return element
     */
    public int get(int index) {
        if(index < noOfElements && index >= 0) {
            return data[index];
        }
        throw new ArrayIndexOutOfBoundsException(index);
    }
    
    /**
     * Sets the element at position index to reference element.
     * Returns the previous value.
     * 
     * @param index
     * @param element
     * @return old element
     */
    public int set(int index, int element) {
        if(index < noOfElements && index >= 0) {
            int oldElement = data[index];
            data[index] = element;
            return oldElement;
        }
        throw new ArrayIndexOutOfBoundsException(index);
    }
    
    /**
     * Returns and removes the item at position index and shifts the 
     * items that follow it to fill the vacated space.
     * 
     * @param index
     * @return removed element
     */
    public int remove(int index) {
        if(index < noOfElements && index >= 0) {
            int element = data[index];
            
            for (int i = index + 1; i < noOfElements; i++) {
                data[i - 1] = data[i]; 
            }
            
            noOfElements--;
            return element;
        }
        throw new ArrayIndexOutOfBoundsException(index);
    }

    /**
     * Searches for target and returns the position of the first occurrence, 
     * or -1 if it is not in the Arraylist.
     * 
     * @param target
     * @return index
     */
    public int indexOf (int target) {
        for(int i=0; i<noOfElements; i++) {
            if(data[i] == target) {
                return i;
            }
        }

        return -1;
    }
    
    /**
     * Gets the current size of the Arraylist.
     * 
     * @return current size
     */
    public int size() {
        return noOfElements;
    }
    
    private void reallocate() {
        maxSize *= 2;
        data = Arrays.copyOf(data, maxSize);
    }


}

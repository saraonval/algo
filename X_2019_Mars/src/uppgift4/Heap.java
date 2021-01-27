/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uppgift4;

import java.util.Arrays;

/**
 *
 * @author saraonval
 */
public class Heap {
    
    private int size;
    private int[] a;
    
    public Heap(int maxSize) {
        a = new int[maxSize];
        size = 0;
    }
    
    public boolean offer(int data) {
        if (size == a.length) {
            reallocate();
        }
        a[size] = data;
        reheapOffer(size);
        size++;
        return true;
    }
    
    private void reheapOffer(int pos) {
        int parent = (pos-1)/2;
        if (pos != 0 && a[pos] < a[parent]) {
            swap(pos, parent);
            reheapOffer(parent);
        }
    }
    
    private void swap(int index1, int index2) {
        int tmp = a[index1];
        a[index1] = a[index2];
        a[index2] = tmp;
    }
    
    private void reallocate() {
        a = Arrays.copyOf(a, a.length*2);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<size-1; i++) {
            sb.append(a[i] + ", ");
        }
        sb.append(a[size-1]);
        return sb.toString();
    }
    
}

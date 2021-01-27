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
    
    private int a[];
    private int size;
    
    public Heap(int maxSumma) {
        a = new int[maxSumma];
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
    
    private void swap(int p1, int p2) {
        int tmp = a[p1];
        a[p1] = a[p2];
        a[p2] = tmp;
    }
    
    private void reallocate() {
        a = Arrays.copyOf(a, a.length*2);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<size-1; i++) {
            sb.append(a[i]);
            sb.append(", ");
        }
        sb.append(a[size-1]);
        return sb.toString();
    }
    
}

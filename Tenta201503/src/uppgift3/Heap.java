/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uppgift3;

/**
 *
 * @author saraonval
 */
public class Heap {
    
    private static int MAX_SIZE = 1000;
    private int[] a;
    private int size;
    
    public Heap() {
        a = new int[MAX_SIZE];
        size = 0;
    }
    
    public boolean insert(int data) {
        if (size == MAX_SIZE) {
            return false;
        }
        
        a[size] = data;
        reheapInsert(size);
        size++;
        
        return true;
    }
    
    private void reheapInsert(int pos) {
        int parent = (pos-1)/2;
        if (pos != 0 && a[pos] < a[parent]) {
            swap(pos, parent);
            reheapInsert(parent);
        }
    }
    
    private void swap(int p1, int p2) {
        int tmp = a[p1];
        a[p1] = a[p2];
        a[p2] = tmp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<size-1; i++) {
            sb.append(a[i]);
            sb.append(", ");
        }
        sb.append(a[size-1]);
        return sb.toString();
    }
    
}

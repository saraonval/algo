package uppgift4;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int size = 20;
        int[] v = new int[size];
        for (int i = 0; i < v.length; i++) {
            v[i] = (int) (Math.random() * size * 10);
        }

        heapSort(v);

        System.out.println(Arrays.toString(v));
        for (int i = 0; i < v.length - 1; i++) {
            if (v[i] > v[i + 1]) {
                System.out.println("error");
                break;
            }
        }
    }

    public static int[] heapSort(int[] a) {
        
        int heapSize = 1;
        
        while (heapSize < a.length) {
            // Offer
            int p = heapSize;
            int parent = (p-1)/2;
            while (p != 0 && a[p] > a[parent]) {
                swap(a, p, parent);
                p = parent;
                parent = (p-1)/2;
            }
            heapSize++;
        }
        
        while (heapSize > 1) {
            // Poll
            heapSize--;
            int s = 0;
            swap(a, s, heapSize);
            // Om s har barn, räcker att kolla högerbarn
            while ((2*s)+2 < heapSize) {
                
                int leftChild = (2*s)+1;
                int rightChild = (2*s)+2;
                
                // Hitta största barnet
                int maxChild = rightChild;
                if (a[leftChild] > a[maxChild]) {
                    maxChild = leftChild;
                }
                
                // Byt plats med största barnet
                if (a[s] < a[maxChild]) {
                    swap(a, s, maxChild);
                    s = maxChild;
                }
            }
            
            // Kolla om det finns vänsterbarn
            int leftChild = (2*s)+1;
            if (leftChild < heapSize && a[leftChild] > a[s]) {
                swap(a, leftChild, s);
            }
            
        }
        
        return a;
    }
    
    private static void swap(int[] a, int index1, int index2) {
        int tmp = a[index1];
        a[index1] = a[index2];
        a[index2] = tmp;
    }

}

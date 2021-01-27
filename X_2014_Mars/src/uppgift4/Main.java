package uppgift4;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] a = {3, 6, 4, 2, 9, 23, 1, 18, 2, 8, 12};
        sort(a);
        for (int e : a) {
            System.out.print(e + ",");
        }
    }
    
    private static void sort(int[] a) {
        if (a.length == 1) {
            return;
        }
        
        // 1
        int[] b = Arrays.copyOfRange(a, 0, a.length/2);
        int[] c = Arrays.copyOfRange(a, a.length/2, a.length);
        
        // 2
        sort(b);
        
        // 3
        sort(c);
        
        // 4
        merge(b, c, a);
    }
    
    private static void merge(int[] a, int[] b, int[] c) {
        int indexA = 0, indexB = 0, indexC = 0;
        
        while (indexA < a.length && indexB < b.length) {
            if (a[indexA] <= b[indexB]) {
                c[indexC++] = a[indexA++];
            }
            else {
                c[indexC++] = b[indexB++];
            }
        }
        
        while (indexA < a.length) {
            c[indexC++] = a[indexA++];
        }
        
        while (indexB < b.length) {
            c[indexC++] = b[indexB++];
        }
    }

}

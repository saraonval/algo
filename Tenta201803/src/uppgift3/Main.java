package uppgift3;

import java.util.Arrays;


public class Main {

    public static void main(String[] args) {
        int[] v = {12,2,3,4,1,7,3,21,10,2,18,17};
        mergeSort(v);
        System.out.println(Arrays.toString(v));
    }
    
    private static void mergeSort(int[] a) {
        if (a.length == 1) {
            return;
        }
        int[] b = Arrays.copyOfRange(a, 0, a.length/2);
        int[] c = Arrays.copyOfRange(a, a.length/2, a.length);
        mergeSort(b);
        mergeSort(c);
        merge(b, c, a);
    }
    
    private static void merge(int[] a, int[] b, int[] c) {
        int indexA = 0, indexB = 0, indexC = 0;
        while (indexA < a.length && indexB < b.length) {
            if (a[indexA] <= b[indexB]) {
                c[indexC++] = a[indexA++];
            } else {
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
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

    public static void heapSort(int[] a) {

        int heapSize = 1, e;

        while (heapSize < a.length) {
            offer(a, heapSize);
            heapSize++;
        }

        while (heapSize > 0) {
            e = poll(a, heapSize);
            heapSize--;
            a[heapSize] = e;
        }

    }

    private static void swap(int[] a, int index1, int index2) {
        int tmp = a[index1];
        a[index1] = a[index2];
        a[index2] = tmp;
    }

    private static void offer(int[] a, int pos) {
        int parent = (pos - 1) / 2;
        while (pos != 0 && a[pos] > a[parent]) {
            swap(a, pos, parent);
            pos = parent;
            parent = (pos - 1) / 2;
        }
    }
    
    private static int poll(int[] a, int pos) {
        int returnData = a[0];
        a[0] = a[pos-1];
        pos = 0;
        while (2 * pos + 2 < pos) {
            int rightChild = (pos * 2) + 2;
            int leftChild = (pos * 2) + 1;

            int maxChild = leftChild;
            if (a[rightChild] > a[leftChild]) {
                maxChild = rightChild;
            }

            if (a[maxChild] > a[pos]) {
                swap(a, maxChild, pos);
                pos = maxChild;
            }
        }
        int leftChild = (pos * 2) + 1;
        if (leftChild < pos && a[leftChild] > a[pos]) {
            swap(a, leftChild, pos);

        }
        return returnData;
    }

}

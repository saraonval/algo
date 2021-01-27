
import java.util.Arrays;

/**
 *
 * @author Sara Onval
 */
public class Main {
    
    public static int[] heapSort(int[] array) {
        
        int heapSize = 1;
        while (heapSize < array.length) {
            
            // **** Offer ****
            // p = elmeentets plats
            int p = heapSize;
            int parent = (p - 1) / 2;
            
            // Steg 2:
            // Medans elementet inte är i rotnoden och elementets nyckel är större än förälderns nyckel:
            // byt plats på förälder och elementet
            
            while (p != 0 && array[p] > array[parent]) {
                swap(array, parent, p);
                p = parent;
                parent = (p - 1) / 2;
            }
            // **** ****
            
            heapSize++;
        }

        while (heapSize > 1) {
            heapSize--;
            
            // **** Poll ****
            int s = 0; 
            // s = platsen där vi tog bort elementet, från början rot
            // eftersom max alltid finns högst upp
            swap(array, s, heapSize);
            
            // Steg 2:
            // Så länge S har barn och S har mindre nyckel än något av sina barn:
            // swappa S med största barnet
            
            // kolla om s har barn (räcker med att kolla höger barn, då finns vänster)
            while (2 * s + 2 < heapSize) {
                
                int leftChild = 2 * s + 1;
                int rightChild = 2 * s + 2;
                
                // Hitta största barnet
                int maxChild = rightChild;
                if (array[leftChild] > array[rightChild]) {
                    maxChild = leftChild;
                }
                
                // Byt plats med största barnet
                if (array[s] < array[maxChild]) {
                    swap(array, s, maxChild);
                    s = maxChild;
                } 
            }
            
            // Kolla om vänster barn finns kvar
            int leftChild = 2 * s + 1;
            if (leftChild < heapSize && array[leftChild] > array[s]) {
                swap(array, s, leftChild);
            }
            // **** ****

        }
        return array;
    }

    // Hjälpmetod
    // Byter plats mellan två element i en array
    private static void swap(int array[], int index1, int index2) {
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

    public static void main(String[] args) {

        int a[] = {92, 98, 45, 12, 2, 3, 6, 86};
        //int a[] = {4, 2, 7, 1, 3};

        System.out.println(Arrays.toString(heapSort(a)));
    }

}

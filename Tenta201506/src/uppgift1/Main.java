package uppgift1;

public class Main {

    public static void main(String[] args) {

        int[] n1 = {1, 3, 2, 34, 9, 82, 14, 10, 8, 12};
        int[] n2 = {3, 5, 14, 23, 23, 24, 28, 39, 41, 102, 106};
        System.out.println(search(n1, 14));
        System.out.println(binarySearch(n2, 39));
    }
    
    public static int search(int[] a, int target) {
        return search(a, target, 0);
    }
    
    private static int search(int[] a, int target, int index) {
        if (index >= a.length) {
            return -1;
        }
        if (a[index] == target) {
            return index;
        }
        return search(a, target, index+1);
    }
    
    public static int binarySearch(int[] a, int target) {
        return binarySearch(a, target, 0, a.length-1);
    }
    
    private static int binarySearch(int[] a, int target, int first, int last) {
        if (first > last) {
            return -1;
        }
        int middle = (first+last)/2;
        if (a[middle] == target) {
            return middle;
        }
        if (target < a[middle]) {
            return binarySearch(a, target, first, middle-1);
        }
        return binarySearch(a, target, middle+1, last);
    }
    
}

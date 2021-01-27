package uppgift3;

public class Heap {

    private static int MAX_SIZE = 1000;
    private int[] a;
    private int size;
    
    public Heap() {
        a = new int[MAX_SIZE];
        size = 0;
    }

    public boolean offer(int data) {
        if (size == MAX_SIZE) {
            return false;
        }
        a[size] = data;
        reheapOffer(size);
        size++;
        return false;
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
    
    public int poll() {
        if (size == 0) {
            return Integer.MAX_VALUE;
        }
        int returnData = a[0];
        a[0] = a[size-1];
        size--;
        reheapPoll(0); 
        return returnData;
    }

    private void reheapPoll(int pos) {
        int leftChild = (pos*2)+1, rightChild = (pos*2)+2;
        
        // Saknar barn
        if(leftChild > size-1) {
            return;
        }
        
        // Saknar höger barn
        if (rightChild > size-1) {
            if (a[pos] > a[leftChild]) {
                swap(pos, leftChild);
                reheapPoll(leftChild);
            }
        }
        
        if (a[leftChild] < a[rightChild]) {
            if (a[pos] > a[leftChild]) {
                swap(pos, leftChild);
                reheapPoll(leftChild);
            }
        }
        
        else {
            if (a[pos] > a[rightChild]) {
                swap(pos, rightChild);
                reheapPoll(rightChild);
            }
        }
    }
}

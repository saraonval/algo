/**
 * Heap
 *
 * @author Sara Onval
 */
public class Heap {

    static final int MAXSIZE = 1000;
    int[] a;
    int size;

    public Heap() {
        a = new int[MAXSIZE];
        size = 0;
    }

    // sätter in elementet på plats sista platsen i arrayen i heapen
    public boolean offer(int data) {
        if (size == MAXSIZE) {
            return false;
        }
        a[size] = data;
        // hjälpmetod, steg 2
        reheapOffer(size);
        size++;
        return true;
        
    }

    // vi kallar på denna tills vi får minsta talet längst upp
    private void reheapOffer(int pos) {
        // Om pos har förälder (p-1/2)
        int parent = (pos-1)/2;
        if (pos != 0 && a[pos] < a[parent]) {
            // byt plats mellan pos och föräldern
            int tmp = a[pos];
            a[pos] = a[parent];
            a[parent] = tmp;
            // rekursion, tills vi är i rotnoden, pos = 1
            reheapOffer(parent);
        }
    }

    // tar bort ett element ur heapen och returnerar detta
    public int poll() {
        if (size == 0) {
            return Integer.MAX_VALUE;
        }
        // returnerar första elementet
        int returnData = a[0];
        a[0] = a[size - 1];
        size--;
        // hjälpmetod, steg 2
        reheapPoll(0);
        return returnData;
    }

    private void reheapPoll(int pos) {
        int tmp;
        int leftChild = 2 * pos + 1;
        if (leftChild > size - 1) {
            return;//saknar barn
        }
        // Höger barn?
        if (2 * pos + 2 > size - 1) {//saknar högerbarn
            if (a[pos] > a[2 * pos + 1]) {
                tmp = a[pos];
                a[pos] = a[2 * pos + 1];
                a[2 * pos + 1] = tmp;
                reheapPoll(2 * pos + 1);
            }
            return;
        }
        // Vänster barn < höger barn
        if (a[2 * pos + 1] < a[2 * pos + 2]) {
            // pos > vänster barn
            if (a[pos] > a[2 * pos + 1]) {
                tmp = a[pos];
                a[pos] = a[2 * pos + 1];
                a[2 * pos + 1] = tmp;
                reheapPoll(2 * pos + 1);
            }
        } else {
            // Pos > höger barn
            if (a[pos] > a[2 * pos + 2]) {
                tmp = a[pos];
                a[pos] = a[2 * pos + 2];
                a[2 * pos + 2] = tmp;
                reheapPoll(2 * pos + 2);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size - 1; i++) {
            sb.append(a[i]);
            sb.append(",");
        }
        sb.append(a[size - 1]);
        return sb.toString();
    }
}

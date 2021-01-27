
/**
 * Max-Heap
 *
 * @author Sara Onval
 */
public class Heap {

    /*
    Förälder = (p-1)/2
    Barn V = (2p+1)
    Barn H = (2p+2)
     */
    private int a[];
    private int size;
    private int MAX_SIZE = 1000;

    public Heap() {
        a = new int[MAX_SIZE];  // Allokera minne för arrayen
        size = 0;
    }

    // Sätt in nytt element på första lediga plats
    public boolean offer(int element) {

        // Kolla om storleken överskridit max gränsen
        if (size == MAX_SIZE) {
            return false;
        }

        a[size] = element;
        // fixa
        fixOffer(size); // vi stoppade in elementet sist, så vi skickar med det indexet
        size++;
        return true;
    }

    // Max                                                          större
    // Medans elementet inte är i rotnoden och elementets nyckel är mindre än förälderns nyckel:
    // byt plats på förälder och elementet
    // p = platsen där vi stoppade in elementet
    private void fixOffer(int p) {
        int parent = (p - 1) / 2;
        if (a[p] != 0 && a[p] > a[parent]) {
            swap(p, parent);
            // rekursion
            fixOffer(parent); // nya p = förälderns index
        }
    }

    // Ersätt elementet i rotnoden med elementet i sista noden i trädet (kalla elementet S)
    public int poll() {
        if (size == 0) {
            return Integer.MAX_VALUE;
        }
        int removedElement = a[0];
        a[0] = a[size - 1];
        size--;
        fixPoll(0);
        return removedElement;
    }

    // Max                           mindre
    // Så länge S har barn och S har större nyckel än något av sina barn:
    // swappa S med minsta barnet
    // s = index av rotnoden som byttes ut med det borttagna elementet som var det sista
    private void fixPoll(int s) {

        int leftChild = 2 * s + 1;
        int rightChild = 2 * s + 2;

        // Om S har vänster barn
        // rot = minst nyckel
        // barn = högre nyckel
        // s saknar left child
        if (leftChild > size - 1) {
            return;
        }

        // s saknar höger barn
        if (rightChild > size - 1) {
            // kolla om s har större nyckel än vänster barn
            if (a[s] < a[leftChild]) {
                swap(s, leftChild);
                fixPoll(leftChild);
            }
            return;
        }

        // Vänster barn < höger barn
        if (a[leftChild] < a[rightChild]) {
            if (a[s] < a[rightChild]) {
                swap(s, rightChild);
                fixPoll(rightChild);
            }
            // s har större nyckel än vänster barn
            if (a[s] < a[leftChild]) {
                swap(s, leftChild); // byt s med vänster barn
                fixPoll(leftChild); // s är nu vänster barn
            }
        } 
        // annars är vänster barn > höger barn
        // s har större nyckel än vänster barn
        else if (a[s] < a[leftChild]) {
            swap(s, leftChild); // byt s med vänster barn
            fixPoll(leftChild); // s är nu vänster barn
        }

    }

    // Swappar två element
    private void swap(int index1, int index2) {
        int tmp = a[index1];
        a[index1] = a[index2];
        a[index2] = tmp;
    }

}

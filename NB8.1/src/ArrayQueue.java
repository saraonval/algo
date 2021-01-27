
import java.util.Arrays;

public class ArrayQueue<E> {

    private int front, rear, size, maxSize;
    private E[] data;

    public ArrayQueue(int initialSize) {
        size = 0;
        front = 0;
        maxSize = initialSize;
        rear = 0;
        data = (E[]) new Object[maxSize];
    }

    public boolean offer(E element) {
        if (size == maxSize) {
            reallocate();
        }
        data[rear] = element;
        rear = rear + 1 % maxSize;  // !
        size++;
        return true;
    }

    public E peek() {
        if (size == 0) {
            return null;
        }
        return data[front];
    }

    public E poll() {
        if (size == 0) {
            return null;
        } else {
            size--;
            E element = data[front];
            front = front + 1 % maxSize; // !
            return element;
        }
    }

    @Override
    public String toString() {
        String s = "";
        s += "Max Size: " + maxSize + "\n";
        s += "Size: " + size + "\n";
        s += "Front: " + front + "\n";
        s += "Rear: " + rear + "\n";
        int fakeFront = front;
        for (int i = 0; i < size; i++) {
            s += data[fakeFront + i] + "\n";
        }
        return s;
    }

    // !
    private void reallocate() {
        maxSize *= 2;
        data = Arrays.copyOf(data, maxSize);
        
        // Rättning:
        /*
        int newMaxSize = maxSize * 2;
        E[] newData = (E[]) new Object[newMaxSize];
        int j = front; // kan ligga mitt i
        for(int i=0; i<size; i++) {
            newData[i] = data[j];
            j = (j+1) % maxSize; // tar hänsyn till att j kan loopa
        }
        front = 0;
        rear = size-1;
        maxSize = newMaxSize;
        data = newData;
*/
    }

}

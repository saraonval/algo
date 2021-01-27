
public class LinkedQueue<E> {

    private static class Node<E> {

        private E data;
        private Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> front;  // head
    private Node<E> rear;   // tail
    private int size;

    public LinkedQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    public void enqueue(E data) {
        if (rear != null) {
            rear.next = new Node<E>(data, null);    // sista nodens next
            rear = rear.next;
        } else {
            front = rear = new Node<E>(data, null);
        }
        size++;
    }

    public E dequeue() {
        if (front != null) {
            E data = front.data;
            front = front.next;
            if (front == null) {
                rear = null;
            }
            size--;
            return data;
        }
        return null;
    }

    public int size() {
        return size;
    }

}

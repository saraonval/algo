
public class Dequeue<E> {

    private static class Node<E> {

        private E data;
        private Node<E> next;
        private Node<E> prev;

        public Node(E data, Node<E> next, Node<E> prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node<E> front;
    private Node<E> rear;
    private int size;

    public Dequeue() {
        front = null;
        rear = null;
        size = 0;
    }

    /**
     * Inserts i tem at the front of the deque. Returns true if succesfus l;
     * returns fal se if the item could not be inserted.
     *
     * @param item
     * @return
     */
    public boolean offerFirst(E item) {
        if (front != null) {
            // nya första elementet
            front.prev = new Node<E>(item, front, null);
            front = front.prev;
        } else {
            // Om kön är tom
            rear = front = new Node<E>(item, null, null);
        }
        size++;
        return true;
    }

    /**
     * Inserts i tem at the rear of the deque. Returns true if successful;
     * returns fa1 se if the item could not be inserted.
     *
     * @param item
     * @return
     */
    public boolean offerLast(E item) {
        if (rear != null) {
            rear.next = new Node<E>(item, null, rear);
            rear = rear.next;
        } else {
            front = rear = new Node<E>(item, null, null);
        }
        size++;
        return true;
    }

    /**
     * Removes the entry at the front of the deque and returns it; returns null
     * if the deque is empty.
     *
     * @return
     */
    public E pollFirst() {
        if (front != null) {
            E data = front.data;
            // Om kön är tom
            if (rear == front) {
                front = rear = null;
            }
            else {
                front = front.next;
                front.prev = null;
            }
            
            /*
            if (front == null) {
                rear = null;
            }*/
            
            size--;
            return data;
        }
        return null;
    }

    /**
     * Removes the entry at the rear of the deque and returns it; returns null
     * if the deque is empty.
     *
     * @return
     */
    public E pollLast() {
        if (rear != null) {
            E data = rear.data;
            // Om kön är tom
            if (rear == front) {
                front = rear = null;
            }
            else {
                rear = rear.prev;
                rear.next = null;
            }
            
            /*
            if (rear == null) {
                front = null;
            }*/
            
            size--;
            return data;
        }
        return null;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        Node<E> p = front;
        if(p != null) {
            while(p.next != null) {
                sb.append(p.data.toString());
                sb.append(" ==> ");
                p = p.next;
            }
            sb.append(p.data.toString()); // sista noden
        }
        sb.append("]");
        return sb.toString();
    }

}

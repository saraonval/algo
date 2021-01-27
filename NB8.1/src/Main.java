
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayQueue<String> array = new ArrayQueue(2);
        System.out.println(array);
        array.offer("Grön");
        System.out.println(array);
        array.offer("Blå");
        System.out.println(array);
        array.offer("Rosa");
        System.out.println(array);
        array.offer("Röd");
        
        System.out.println("Poll: " + array.poll());
        System.out.println("Poll: " + array.poll());
        System.out.println(array);
        
        System.out.println(array);
        array.offer("Gul");
        System.out.println(array);
        array.offer("Orange");
        System.out.println(array);
        array.offer("Lila");
        System.out.println(array);
        array.offer("Turkos");

        System.out.println(array);
        System.out.println("-------------------------------");
        System.out.println("Peek: " + array.peek());
        System.out.println("Poll: " + array.poll());
        System.out.println("Poll: " + array.poll());
        System.out.println("Poll: " + array.poll());
        System.out.println("Peek: " + array.peek());
        System.out.println("-------------------------------");
        System.out.println(array);
        System.out.println("-------------------------------");
        System.out.println("Peek: " + array.peek());
        System.out.println("Poll: " + array.poll());
        System.out.println("Poll: " + array.poll());
        System.out.println("Poll: " + array.poll());
        System.out.println("Poll: " + array.poll());
        System.out.println("Poll: " + array.poll());
        System.out.println("Peek: " + array.peek());
        System.out.println("-------------------------------");
        System.out.println(array);
    }

}

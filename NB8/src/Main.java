
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayQueue<String> array = new ArrayQueue(10);
        System.out.println("Max Size: " + array.getMaxSize());
        array.offer("Armin");
        System.out.println("\n" + array.toString());
        System.out.println("Max Size: " + array.getMaxSize());
        array.offer("Nicklas");
        System.out.println("\n" + array.toString());
        System.out.println("Max Size: " + array.getMaxSize());
        array.offer("Cajander");
        System.out.println("\n" + array.toString());
        System.out.println("Max Size: " + array.getMaxSize());
        array.offer("Reine");
        System.out.println("\n" + array.toString());
        System.out.println("Max Size: " + array.getMaxSize());
        array.offer("Lindström");
        System.out.println("\n" + array.toString());
        System.out.println("Max Size: " + array.getMaxSize());
        
        System.out.println("\n" + array.toString());
        
        System.out.println("Get size: " + array.getSize());
        System.out.println("-------------------------------");
        System.out.println("Peek: " + array.peek());
        System.out.println("Poll: " + array.poll());
        System.out.println("Poll: " + array.poll());
        System.out.println("Poll: " + array.poll());
        System.out.println("-------------------------------");
        System.out.println("Get size: " + array.getSize());
        System.out.println("Max Size: " + array.getMaxSize());
        
        System.out.println("\n" + array.toString());
        System.out.println("Poll: " + array.poll());
        System.out.println("\n" + array.toString());
    }

}

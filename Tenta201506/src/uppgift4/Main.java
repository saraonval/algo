package uppgift4;

public class Main {

    public static void main(String[] args) {
        //System.out.println(numberConfig(7));
        System.out.println(numberConfig(4));
    }

    public static int numberConfig(int length) {
        if (length == 1) {
            return 1;
        }
        if (length == 2) {
            return 2;
        }
        if (length == 3) {
            return 3;
        }
        return numberConfig(length-1) + numberConfig(length-2) + numberConfig(length-3);
    }
    
}

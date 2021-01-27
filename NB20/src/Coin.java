
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Sara Onval, onval@kth.se
 */
public class Coin {

    // Wrapper
    // Skickar in start = 1
    public static String coinMachine(int points) {
        StringBuilder sb = new StringBuilder();
        return coinMachine(points, 1, sb);
    }

    public static String coinMachine(int points, int start, StringBuilder sb) {

        // Om vi når över poängen, returnera -1
        // Annars kan vi få stackOverflow
        // Den kanske aldrig når villkoret som terminerar rekursionen
        if (start > points) {
            return "";
        }

        // Villkoret som terminerar rekursionen
        // Vi ska räkna upp start, som är 1, till poängen
        if (start == points) {
            return sb.toString();
        }
        
        if (start * 3 <= points) {
            return coinMachine(points, start * 3, sb.append(" 10 => "));
        }
        
        if (start + 4 <= points) {
            return coinMachine(points, start + 4, sb.append(" 5 => "));
        }
        
        return "";

    }

    public static void main(String[] args) {
        System.out.print("Vilken poäng ska uppnås: ");
        Scanner scanner = new Scanner(System.in);
        int points = scanner.nextInt();
        System.out.println("Poängen kan nås med " + coinMachine(points));
    }
}
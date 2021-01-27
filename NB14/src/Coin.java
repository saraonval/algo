
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
    public static int coinMachine(int points) {
        return coinMachine(points, 1);
    }

    public static int coinMachine(int points, int start) {

        // Om vi når över poängen, returnera -1
        // Annars kan vi få stackOverflow
        // Den kanske aldrig når villkoret som terminerar rekursionen
        if (start > points) {
            return -1;
        }

        // Villkoret som terminerar rekursionen
        // Vi ska räkna upp start, som är 1, till poängen
        if (start == points) {
            return 0;
        }

        // Rekursion
        int tenPoints = coinMachine(points, start * 3);
        int fivePoints = coinMachine(points, start + 4);

        // Om vi nådde över gränsen
        if (tenPoints == -1 && fivePoints == -1) {
            return -1;
        } // Om tian nådde över gränsen, returnera femman
        else if (tenPoints == -1) {
            return 5 + fivePoints;
        } // Om femman nådde över gränsen, returnera tian
        else if (fivePoints == -1) {
            return 10 + tenPoints;
        } 
        // Om ingen av femman eller tian nådde över gränsen
        // Kolla vilken som har minst värde, och returnera den minsta
        else {
            // "... beräkna LÄGSTA belopp som krävs för att uppnå poängen exakt"
            int min = Math.min(tenPoints, fivePoints);
            if (min == tenPoints) {
                return 10 + tenPoints;
            } else {
                return 5 + fivePoints;
            }
        }

    }

    public static void main(String[] args) {
        System.out.print("Vilken poäng ska uppnås: ");
        Scanner scanner = new Scanner(System.in);
        int points = scanner.nextInt();
        System.out.println("Poängen kan nås med " + coinMachine(points) + " öre");
    }
}

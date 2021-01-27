/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author saraonval
 */

/*
    Skriv ett program som löser det generella växlingsproblemet. 
    Användaren får först ange hur många olika valutor det finns och sedan valören på dessa.
    
    Därefter får denne ange vilket belopp som skall växlas och programmet svarar med minsta antalet mynt och sedlar som behövs. 
    Lägg till att programmet också skriver ut växeln.
 */

import java.util.*;

public class Main {

    public static void main(String args[]) {
        System.out.print("Enter number of currency: ");
        Scanner scan = new Scanner(System.in);
        int noOfCurrency = scan.nextInt();
        scan.nextLine();

        int[] coins = new int[noOfCurrency];

        for (int i = 0; i < noOfCurrency; i++) {
            System.out.print("Enter currency " + i + ": ");
            coins[i] = scan.nextInt();
        }

        System.out.print("Enter cash: ");
        int cash = scan.nextInt();
        scan.nextLine();

        System.out.println("Minimum currency required: " + exchange(coins, cash));
    }
    
    public static int exchange(int[] coins, int cash) {
        int[] results = new int[coins.length];
        return exchange(coins, cash, results);
    }

    private static int exchange(int[] coins, int cash, int[] result) {

        for (int i = 0; i < coins.length; i++) {
            // Om mynt[i]=belopp - return 1
            if (cash == coins[i]) {
                return 1;
            }
        }

        // v=belopp
        int v = cash;

        // För i = 1 till belopp/2
        for (int i = 1; i <= cash / 2; i++) {
            // v=min(v,växel(i)+växel(belopp-i))
            v = Math.min(v, exchange(coins, i) + exchange(coins, cash - i));
        }
        
        return v;
    }
}
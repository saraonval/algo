package bredden;

import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Sara Onval
 */
public class LustigaHuset {

    private static class Tillstand {
        public int position, antalResor;
        public Tillstand(int position, int antalResor) {
            this.position = position;
            this.antalResor = antalResor;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // n=78, upp=15, ned=8, destination=35 ger minsta antalet resor till 13
        System.out.println(antalResorHiss(78, 15, 8, 35));
    }

    public static int antalResorHiss(int n, int upp, int ned, int destination) {
        Queue<Tillstand> q = new LinkedList<Tillstand>();
        Tillstand t = new Tillstand(1, 0);
        
        // Motsatsen till terminerande villkor
        while(t.position != destination) {
            // Kolla om det går att åka upp
            if (t.position + upp <= n) {
                q.offer(new Tillstand(t.position+upp, t.antalResor+1)); // Köar nya tillståndet
            }
            // Kolla om det går att åka ner
            if (t.position - ned >= 1) {
                q.offer(new Tillstand(t.position-ned, t.antalResor+1)); // Köar nya tillståndet
            }
            // Avköa det som ligger först i kön
            t = q.poll();
            // Kolla om det uppfyller tillståndet
            // Om inte, gå igenom loopen
            // Ända tills position == destination
        }
        return t.antalResor;
    }

    private static int antalResorHiss(int n, int upp, int ned, int destination,
            int position, int antalResor) {

        // Terminerande villkor
        if (position == destination) {
            return antalResor;          // Vi vill returnera antalet resor!
        } // Stopp villkor
        else if (antalResor > 30) {      // Inte mer än 30 resor
            return Integer.MAX_VALUE;
        }

        int antalUpp = Integer.MAX_VALUE, antalNed = Integer.MAX_VALUE;

        // går att åka upp
        // !!!
        if (position + upp <= n) {
            antalUpp = antalResorHiss(n, upp, ned, destination, position + upp, antalResor + 1);
        }

        // går att åka ned
        // !!!
        if (position - ned >= 1) {
            antalNed = antalResorHiss(n, upp, ned, destination, position - ned, antalResor + 1);
        }

        return Math.min(antalUpp, antalNed);

    }

}

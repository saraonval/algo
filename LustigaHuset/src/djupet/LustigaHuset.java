package djupet;

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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // n=78, upp=15, ned=8, destination=35 ger minsta antalet resor till 13
        System.out.println(antalResorHiss(78, 15, 8, 35));
    }
    
    public static int antalResorHiss(int n, int upp, int ned, int destination) {
        return antalResorHiss(n, upp, ned, destination, 1, 0);
    }
    
    private static int antalResorHiss(int n, int upp, int ned, int destination, 
            int position, int antalResor) {
        
        // Terminerande villkor
        if (position == destination) {
            return antalResor;          // Vi vill returnera antalet resor!
        }
        
        // Stopp villkor
        else if(antalResor > 30) {      // Inte mer än 30 resor
            return Integer.MAX_VALUE;
        }
        
        int antalUpp = Integer.MAX_VALUE, antalNed = Integer.MAX_VALUE;
        
        // går att åka upp
        // !!!
        if (position+upp <= n) {
            antalUpp = antalResorHiss(n, upp, ned, destination, position+upp, antalResor+1);
        }
        
        // går att åka ned
        // !!!
        if (position-ned >= 1) {
            antalNed = antalResorHiss(n, upp, ned, destination, position-ned, antalResor+1);
        }
        
        return Math.min(antalUpp, antalNed);
        
    }
    
}

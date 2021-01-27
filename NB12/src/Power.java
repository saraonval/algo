/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sara Onval, onval@kth.se
 */
public class Power {
    
    // Rekusiv power metod
    public static int powerRek(int base, int exponent) {
        // Villkor
        if (exponent == 0) {
            return 1;
        }
        // Ändra på talet som leder till villkoret
        return base * powerRek(base, exponent-1);
    }
    
    // Iterativ power metod
    public static int powerIt(int base, int exponent) {
        int result = 1;
        for(int i=0; i<exponent; i++) {
            result *= base;
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println("(Rekursion) 3^3 = " + powerRek(3, 3));
        System.out.println("(Iteration) 3^3 = " + powerIt(3, 3));
    }
}

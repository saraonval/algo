/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sara Onval, onval@kth.se
 */
public class Root {
    
    public static double root (double n) {
        return root(n, 1, 0.001);
    }
        
    private static double root (double n, double a, double e) {

        if (Math.abs(a*a-n) < e) {
            return a;
        }
        
        return root(n, (a*a+n)/(2*a), e);
    }
    
    public static void main(String[] args) {
        // e = 3 eftersom det ska va 3 decimalers noggranhet
        System.out.println("n=9: " + root(9));
        System.out.println("n=5: " + root(5));
        System.out.println("n=2: " + root(2));
        System.out.println("n=8: " + root(8));
    }
}

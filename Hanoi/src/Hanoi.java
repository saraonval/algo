/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author saraonval
 */
public class Hanoi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        hanoi(3,1,2,3);
        // n=3 antal brickor
        // f=1 första
        // t=2 andra
        // x=3 tredje
    }
    
    public static void hanoi(int n, int f, int t, int x) {
        if (n > 0) {
            hanoi(n - 1, f, x, t);
            System.out.println(f + "->" + t);
            hanoi(n - 1, x, t, f);
        }
    }
    
}

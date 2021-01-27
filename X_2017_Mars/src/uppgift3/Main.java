/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uppgift3;

/**
 *
 * @author saraonval
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(noOfWays(5, 6));
    }

    public static int noOfWays(int row, int col) {
        int[][] tab = new int[row+1][col+1];
        tab[0][0] = 1;
        return noOfWays(row, col, tab);
    }
    
    private static int noOfWays(int row, int col, int[][] tab) {
        if (tab[row][col] != 0) {
            return tab[row][col];
        }
        int noOfPaths = 0;
        if (row > 0) {
            noOfPaths = noOfWays(row-1, col, tab);
        }
        if (col > 0) {
            noOfPaths += noOfWays(row, col-1, tab);
        }
        return noOfPaths;
    }
}

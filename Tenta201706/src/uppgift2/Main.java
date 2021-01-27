/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uppgift2;

/**
 *
 * @author bfelt
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[][] a = {   {1,3,4,7,8,3,1},
                        {2,6,2,4,6,1,6},
                        {1,7,1,2,1,5,1},
                        {1,6,1,5,1,8,2},
                        {1,1,8,8,1,9,1}};
   
        System.out.println(findSmallestSum(a));
    }
    
    public static int findSmallestSum(int[][] a) {
        return findSmallestSum(a, 0, 0);
    }
    
    private static int findSmallestSum(int[][] a, int row, int col) {
        
        if (row == a.length-1 && col == a[0].length-1) {
            return a[row][col];
        }
        
        int sumRight = Integer.MAX_VALUE, sumDown = Integer.MAX_VALUE;
        
        if (row < a.length-1) {
            sumDown = findSmallestSum(a, row+1, col);
        }
        
        if (col < a[0].length-1) {
            sumRight = findSmallestSum(a, row, col+1);
        }
        
        return a[row][col] + Math.min(sumDown, sumRight);
    }
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author saraonval
 */
public class Points {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int noOfPoints = (int) (Math.random() * 100);
        System.out.println("Number of points: " + noOfPoints);
        int noOfIntervals = points(noOfPoints);
        System.out.println("Number of intervals: " + noOfIntervals);
    }
    
    public static int points(int noOfPoints) {
        int noOfIntervals = 0;
        
        // om udda
        // för då täcker den inte alla punkter med intervallet
        if (noOfPoints % 2 != 0) {
            return -1;
        }
        
        //  Minska med längden 2 och öka variabeln noOfIntervals varje gång detta görs
        while(noOfPoints > 0) {
            noOfPoints -= 2; // minska med 2 så länge längden är > 0
            noOfIntervals++;
        }
        
        return noOfIntervals;
    }
}

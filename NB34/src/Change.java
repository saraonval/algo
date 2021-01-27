
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author saraonval
 */
public class Change {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] currency = {1000, 500, 100, 50, 20, 10, 5, 1};
        int sum = 789;
        System.out.println(Arrays.toString(change(sum, currency)));
    }

    public static int[] change(int sumToChange, int[] availableCurrency) {
        int[] answer = new int[availableCurrency.length];
        while (sumToChange > 0) {
            for (int i = 0; i < availableCurrency.length; i++) {
                if (availableCurrency[i] <= sumToChange) {
                    int p = availableCurrency[i];
                    sumToChange -= p;
                    answer[i]++;
                }
            }  
        }
        return answer;
    }
}

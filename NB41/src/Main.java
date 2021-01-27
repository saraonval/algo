
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author saraonval
 */
public class Main {
    
    private static int counter= 0; // antal gånger man anropat

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        System.out.print("Enter n (number of integers between -1000 and 1000): ");
        int n = scanner.nextInt();
        
        if (n < 2) {
            n = 2;
        }
        
        IntStream stream =  random.ints(n, -1000, 1000);
        int[] integers = stream.toArray();
        System.out.println(Arrays.toString(integers));
        System.out.println("Max summa = " + maxSum(integers));
        System.out.println("Antal anrop = " + counter);
    }
    
    /*
    public static int maxSum(int[] a) {
        int maxSumma = 0;
        int maxLokal = 0;
        for(int i=0; i<a.length; i++) {
            maxLokal = max(maxLokal + a[i], 0);
            maxSumma = max(maxLokal, maxSumma);
        }
        return maxSumma;
    }
*/
    
    private static int max(int number1, int number2) {
        if (number1 > number2) {
            return number1;
        }
        return number2;
    }
    
    public static int maxSum(int[] array) {
        return maxSum(array, 0, array.length-1);
    }
    
    public static int maxSum(int[] array, int left, int right) {
        if(left > right) {
            return 0;
        }
        else if(left==right) {
            return max(0,array[left]);
        }
        
        int center = (left + right)/2;
        int sum = 0; 
        int maxLeft = 0;
        
        for(int i= center; i >= left; i--) { 
            sum = sum + array[i];
            maxLeft = max(maxLeft,sum);
        }
        sum = 0;
        int maxRight = 0;
        for(int i= center+1; i <=right; i++) {
            sum = sum + array[i];
            maxRight = max(maxRight,sum);
        }
        
        int maxOverCenter = maxLeft + maxRight;
        counter++;
        return max(maxOverCenter, max(maxSum(array,left,center), maxSum(array,center+1,right)));
    }
    
}

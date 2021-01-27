
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sara Onval, onval@kth.se
 */
public class BinaryInt {
    
    // Wrapper
    // Översätter från String till int
    public static int binaryToInt(String binary) {
        int binaryInt = Integer.valueOf(binary);
        return translateBinaryToInt(binaryInt);
    }
    
    private static int translateBinaryToInt(int binary) {
        if (binary == 0) {
            return 0;
        }
        else {
            return (binary % 10 + 2 * translateBinaryToInt(binary / 10));
        }
    }

    // Wrapper
    // Översätter från int till String
    public static String intToBinary(int integer) {
        return String.valueOf(translateIntToBinary(integer));
    }
    
    private static int translateIntToBinary (int integer) {
        if(integer == 0) {
            return 0;
        }
        else {
            return (integer % 2 + 10 * translateIntToBinary(integer / 2));
        }
    } 
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("(0)Binary-To-Int or (1)Int-To-Binary: ");
            int choice = scanner.nextInt();
            if(choice == 0) {
                System.out.println("Enter binary: ");
                String binary = scanner.next();
                System.out.println("Int: " + binaryToInt(binary));
            }
            else {
                System.out.println("Enter int: ");
                int integer = scanner.nextInt();
                System.out.println("Binary: " + intToBinary(integer));
            }
        }
    }
    
}

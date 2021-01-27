package selection;


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
public class SelectionSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] list = {98, 1, 5, 99, 20, 21, 17};
        int[] sorted = selectionSort(list);
        System.out.println(Arrays.toString(sorted));
    }
    
    public static int[] selectionSort(int[] list) {
        for(int index=0; index<list.length-1; index++) {
            int minIndex = index;
            for(int i=index+1; i<list.length; i++) {
                if(list[i]<list[minIndex]) {
                    minIndex = i;
                }
            }
            // Swap
            int old = list[index];
            list[index] = list[minIndex];
            list[minIndex] = old;
        }
        return list;
    }
    
}

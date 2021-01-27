package insertion;


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
public class InsertionSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] list = {98, 1, 5, 99, 20, 21, 17};
        int[] sorted = insertionSort(list);
        System.out.println(Arrays.toString(sorted));
    }

    public static int[] insertionSort(int[] list) {
        for(int index=1; index<list.length; index++) {
            int data = list[index];
            int dataIndex = index;
            while(dataIndex > 0 && data < list[dataIndex-1]) {
                list[dataIndex] = list[dataIndex-1];
                dataIndex--;
            }
            list[dataIndex] = data;
        }
        return list;
    }

}

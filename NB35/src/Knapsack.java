/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;

/**
 *
 * @author saraonval
 */
public class Knapsack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /*
        int size = 20; //kg
        int[] weights = {11, 10}; //kg
        int[] values = {12, 10}; //kr
         */
        // Hardcoded
        /*
        int size = 50; //kg
        int[] weights = {10, 20, 30}; //kg
        int[] values = {60, 100, 120}; //kr
        */

        // From user
        Scanner scanner = new Scanner(System.in);
        System.out.print("How heavy is your knapsack (kg)?: ");
        int size = scanner.nextInt();
        System.out.print("How many packages do you have?: ");
        int iterations = scanner.nextInt();
        int[] weights = new int[iterations];
        int[] values = new int[iterations];
        for (int i = 0; i < iterations; i++) {
            System.out.print("Weight?: ");
            weights[i] = scanner.nextInt();
            System.out.print("Value?: ");
            values[i] = scanner.nextInt();
        }

        System.out.println("\nCalculating your knapsack problem with a greedy algorithm...");

        int[] solution = knapsack(size, weights, values);
        System.out.println("Instance of each package: " + Arrays.toString(solution));
        int value = 0;
        int weight = 0;
        for (int i = 0; i < solution.length; i++) {
            value += solution[i] * values[i];
            weight += solution[i] * weights[i];
        }
        System.out.println("Total price: " + value);
        System.out.println("Total kg: " + weight);
    }

    public static int[] knapsack(int knapsackSize, int[] weights, int[] values) {

        int[] solution = new int[weights.length];

        // Beräkna värdet per vikt för varje vara (kr/kg)
        double[] valuePerWeight = new double[weights.length];
        for (int i = 0; i < weights.length; i++) {
            valuePerWeight[i] = (double) values[i] / (double) weights[i];
        }

        System.out.println("Value per weight array looks like:");
        System.out.println(Arrays.toString(valuePerWeight));

        // Fyll kappsäcken med så många som möjligt av den vara som har högst värde per viktenhet (kr/kg)
        while (knapsackSize > 0 || getMaxValuePerWeightIndex(valuePerWeight) != -1) {

            // högst värde (index)
            int maxValuePerWeightIndex = getMaxValuePerWeightIndex(valuePerWeight);
            valuePerWeight[maxValuePerWeightIndex] = -1;

            // fyll kappsäcken
            while (weights[maxValuePerWeightIndex] <= knapsackSize) {
                int p = weights[maxValuePerWeightIndex];
                knapsackSize -= p;
                solution[maxValuePerWeightIndex]++;
            }
        }

        return solution;
    }

    private static int getMaxValuePerWeightIndex(double[] valuePerWeight) {
        double maxValueWeight = 0;
        int index = -1;
        for (int i = 0; i < valuePerWeight.length; i++) {
            if (valuePerWeight[i] > maxValueWeight) {
                maxValueWeight = valuePerWeight[i];
                index = i;
            }
        }
        return index;
    }
    
    
//    public static void main(String[] args) {
//
//        LinkedList<Activity> list = new LinkedList<>();
//        list.add(new Activity(8, 11, 5));
//        list.add(new Activity(10, 12, 2));
//        list.add(new Activity(11, 13, 3));
//        list.add(new Activity(13, 16, 4));
//        list.add(new Activity(14, 16, 1));
//
//        System.out.println(schedule(list));
//    }
//
//    public static LinkedList<Integer> schedule(LinkedList<Activity> list) {
//        
//        LinkedList<Integer> result = new LinkedList<>();
//        int index = 0;
//        int totalTime = 8;
//        Collections.sort(list, new endTimeComparator());
//        
//        System.out.println("Activity numbers: ");
//        for (Activity a : list) {
//            System.out.println(a.nr);
//        }
//        
//        while (list.size() != 0 && totalTime != 0) {
//            result.add(list.get(index).nr); //Lägger till i result. 
//            int tmp = list.get(index).endTime; 
//            list.remove(index); //Tar bort från V 
//
//            ListIterator<Activity> iter = list.listIterator();
//            while (iter.hasNext()) {
//                int startTime = iter.next().startTime;
//                if (startTime < tmp) {
//                    iter.previous();
//                    iter.remove();
//                }
//            }
//
//            totalTime--;
//        }
//
//        return result;
//    }
//
//    public static class Activity {
//
//        int startTime, endTime, nr;
//
//        public Activity(int startTime, int endTime, int nr) {
//            this.startTime = startTime;
//            this.endTime = endTime;
//            this.nr = nr;
//        }
//    }
//
//    private static class endTimeComparator implements Comparator<Activity> {
//
//        @Override
//        public int compare(Activity o1, Activity o2) {
//            if (o1.endTime == o2.endTime) {
//                return 0;
//            } 
//            else if (o1.endTime < o2.endTime) {
//                return -1;
//            } 
//            else {
//                return 1;
//            }
//        }
//    }
//}
}

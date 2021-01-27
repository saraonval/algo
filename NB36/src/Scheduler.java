
import java.util.ArrayList;
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
public class Scheduler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] startTime = {1, 5, 3, 10};
        int[] endTime = {10, 9, 12, 20};
        String[] activities = {"Sleeping", "Eating", "Programming", "Cleaning"};
        ArrayList<String> mySchedule = schedule(startTime, endTime, activities);
        System.out.println(mySchedule.toString());
    }
    
    public static ArrayList<String> schedule(int[] startTime, int[] endTime, String[] activities) {
        ArrayList<String> solution = new ArrayList<>();
        // V - mängden av alla aktiviteter
        int V = activities.length;
        
        // Medans det finns aktiviteter i V
        while(V > 0) {
            
            // 1. Schemalägg den aktivitet i V som slutar först.
            int minEndTimeIndex = getMinEndTimeIndex(endTime);

//            System.out.println(minEndTimeIndex);
//            System.out.println(startTime[minEndTimeIndex]);
//            System.out.println(endTime[minEndTimeIndex]);

            // 2. Ta bort vald aktivitet ur V
            solution.add(activities[minEndTimeIndex]);
            activities[minEndTimeIndex] = "";
            int end = endTime[minEndTimeIndex];
            int start = startTime[minEndTimeIndex];
            endTime[minEndTimeIndex] = -1;
            startTime[minEndTimeIndex] = -1;
            V--;
            
            // 3. Ta bort alla aktiviteter ur V som överlappar med vald aktivitet
            for(int i=0; i<activities.length; i++) {
                // kolla tillgängliga aktiviteter bara
                if(!activities[i].equals("")) {
                    // kolla om det finns överlappning
                    if (startTime[i] <= start) {
                        System.out.println(startTime[i]);
                        activities[i] = "";
                        startTime[i] = -1;
                        endTime[i] = -1;
                        V--;
                    }
                }
            }
            
        }
        
        return solution;
    }
    
    private static int getMinEndTimeIndex(int[] endTime) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for(int i=0; i<endTime.length; i++) {
            if(endTime[i] < min && endTime[i] != -1) {
                min = endTime[i];
                index = i;
            }
        }
        return index;
    }
}
package uppgift2;

public class Main {

    public static void main(String[] args) {
        System.out.println(counting(57));
        System.out.println(counting2(57));
    }
    
    public static int counting(int goal) {
        return counting(goal, 1);
    }
    
    private static int counting(int goal, int number) {
        
        if (number > goal) {
            return -1;
        }
        
        if (number == goal) {
            return 0;
        }
        
        int times3 = counting(goal, number*3);
        int add4 = counting(goal, number+4);
        
        if (times3 == -1 && add4 == -1) {
           return -1; 
        }
        
        else if (times3 == -1) {
            return 1 + add4;
        }
        
        else if (add4 == -1) {
            return 1 + times3;
        }
        
        return 1 + Math.min(times3, add4);
    }
    
    public static int counting2(int goal) {
        int[] result = new int[goal+1];
        return counting2(goal, 1, result);
    }
    
    private static int counting2(int goal, int number, int[] result) {
        
        if (number > goal) {
            return -1;
        }
        
        if (result[number] != 0) {
            return result[number];
        }
        
        if (number == goal) {
            result[number] = 0;
        }
        
        else {
            int times3 = counting2(goal, number*3, result);
            int add4 = counting2(goal, number+4, result);
            
            if (times3 == -1 && add4 == -1) {
                result[number] = -1;
            }
            
            else if (times3 == -1) {
                result[number] = 1 + add4;
            }
            
            else if (add4 == -1) {
                result[number] = 1 + times3;
            }
            
            else {
                result[number] = 1 + Math.min(times3, add4);
            }
        }
        
        return result[number];
    }

}
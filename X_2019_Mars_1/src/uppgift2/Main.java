package uppgift2;

public class Main {

    public static void main(String[] args) {
        System.out.println(counting(57));
        System.out.println(counting2(57));
    }

    private static int counting(int goal) {
        return counting(goal, 1);
    }
    
    private static int counting(int goal, int number) {
        if (number > goal) {
            return -1;
        }
        if (number == goal) {
            return 0;
        }
        int t3 = counting(goal, number*3);
        int a4 = counting(goal, number+4);
        if (t3 == -1 && a4 == -1) {
            return -1;
        }
        else if (t3 == -1) {
            return 1 + a4;
        }
        else if (a4 == -1) {
            return 1 + t3;
        }
        else {
            return 1 + Math.min(t3, a4);
        }
    }
    
    private static int counting2(int goal) {
        int[] tab = new int[goal+1];
        return counting2(goal, 1, tab);
    }
    
    private static int counting2(int goal, int number, int[] tab) {
        
        if (number > goal) {
            return -1;
        }
        
        if (tab[number] != 0) {
            return tab[number];
        }
        
        if (number == goal) {
            tab[number] = 0;
        }
        
        int t3 = counting2(goal, number*3, tab);
        int a4 = counting2(goal, number+4, tab);
        
        if (t3 == -1 && a4 == -1) {
            return -1;
        }
        else if (t3 == -1) {
            tab[number] = 1 + a4;
        }
        else if (a4 == -1) {
            tab[number] = 1 + t3;
        }
        else {
            tab[number] = 1 + Math.min(t3, a4);
        }
        return tab[number];
    }
}
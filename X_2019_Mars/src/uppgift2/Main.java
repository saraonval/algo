package uppgift2;

public class Main {

    public static void main(String[] args) {
        System.out.println(counting(57));
        System.out.println(counting2(57));
    }

    public static int counting(int goal) {
        return counting(goal, 1);
    }

    private static int counting(int goal, int start) {

        if (start > goal) {
            return -1;
        }

        if (goal == start) {
            return 0;
        }

        int times3 = counting(goal, start * 3);
        int add4 = counting(goal, start + 4);

        if (times3 == -1 && add4 == -1) {
            return -1;
        }

        if (times3 == -1) {
            return 1 + add4;
        }

        if (add4 == -1) {
            return 1 + times3;
        }

        return 1 + Math.min(add4, times3);

    }

    public static int counting2(int goal) {
        int[] tab = new int[goal + 1];
        for (int i = 0; i < tab.length; i++) {
            tab[i] = 0;
        }
        return counting2(goal, 1, tab);
    }

    private static int counting2(int goal, int start, int[] tab) {

        if (start > goal) {
            return -1;
        }

        if (tab[goal] != 0) {
            return tab[goal];
        }

        if (goal == start) {
            return 0;
        }

        int times3 = counting(goal, start * 3);
        int add4 = counting(goal, start + 4);

        if (times3 == -1 && add4 == -1) {
            return -1;
        }

        if (times3 == -1) {
            tab[goal] = 1 + add4;
        }

        if (add4 == -1) {
            tab[goal] = 1 + times3;
        }

        tab[goal] = 1 + Math.min(add4, times3);

        return tab[goal];
    }
}

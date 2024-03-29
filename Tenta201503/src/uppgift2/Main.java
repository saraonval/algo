package uppgift2;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int t = -1;
        int[][] pyramid = {{5, t, t, t, t, t, t, t, t, t},
        {3, 1, t, t, t, t, t, t, t, t},
        {4, 7, 6, t, t, t, t, t, t, t},
        {6, 8, 0, 9, t, t, t, t, t, t},
        {9, 2, 3, 5, 4, t, t, t, t, t},
        {8, 0, 5, 6, 1, 2, t, t, t, t},
        {2, 9, 7, 1, 0, 3, 5, t, t, t},
        {0, 7, 1, 6, 2, 9, 4, 8, t, t},
        {6, 1, 5, 0, 4, 2, 7, 9, 3, t},
        {9, 3, 2, 7, 8, 6, 4, 1, 5, 0}};

        solve(pyramid);
    }
    
    public static void solve(int[][] pyramid) {
        boolean[] used = new boolean[pyramid.length];
        int[] order = new int[pyramid.length];
        if (solve(pyramid, used, order, 0, 0)) {
            System.out.println(Arrays.toString(order));
        }
        else {
            System.out.println("Olösbar!");
        }
    }
    
    private static boolean solve(int[][] pyramid, boolean[] used, int[] order, int level, int place) {
        if (used[pyramid[level][place]]) {
            return false;
        }
        used[pyramid[level][place]] = true;
        order[level] = pyramid[level][place];
        if (level == pyramid.length-1) {
            return true;
        }
        if (solve(pyramid, used, order, level+1, place)) {
            return true;
        }
        if (solve(pyramid, used, order, level+1, place+1)) {
            return true;
        }
        used[pyramid[level][place]] = false;
        return false;
    }

}
